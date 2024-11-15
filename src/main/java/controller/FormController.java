package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Utilisateur;

@WebServlet("/FormController")
public class FormController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String codePostal = request.getParameter("codePostal");
        String[] transportsArray = request.getParameterValues("transports");

        // Validation des champs requis
        if(nom == null || nom.isEmpty() ||
           prenom == null || prenom.isEmpty() ||
           sexe == null || sexe.isEmpty() ||
           codePostal == null || codePostal.isEmpty()) {

            // Redirection vers le formulaire si des champs sont manquants
            request.setAttribute("errorMessage", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("formulaire.jsp").forward(request, response);
        } else {
            // Création de l'objet modèle
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setSexe(sexe);
            utilisateur.setCodePostal(codePostal);

            if(transportsArray != null) {
                List<String> transports = Arrays.asList(transportsArray);
                utilisateur.setTransports(transports);
            }

            // Récupérer la session
            HttpSession session = request.getSession();

            // Récupérer la liste des utilisateurs depuis la session
            @SuppressWarnings("unchecked")
			List<Utilisateur> listeUtilisateurs = (List<Utilisateur>) session.getAttribute("listeUtilisateurs");

            // Si la liste n'existe pas encore, la créer
            if (listeUtilisateurs == null) {
                listeUtilisateurs = new ArrayList<Utilisateur>();
            }

            // Ajouter le nouvel utilisateur à la liste
            listeUtilisateurs.add(utilisateur);

            // Mettre à jour la liste dans la session
            session.setAttribute("listeUtilisateurs", listeUtilisateurs);

            // Envoyer la liste des utilisateurs à la vue
            request.setAttribute("listeUtilisateurs", listeUtilisateurs);

            // Rediriger vers la page de résultats
            request.getRequestDispatcher("resultat.jsp").forward(request, response);
        }
    }
}
