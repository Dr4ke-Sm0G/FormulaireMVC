<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Résultats</title>
</head>
<body>
    <h2>Liste des Utilisateurs</h2>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Sexe</th>
            <th>Code Postal</th>
            <th>Transports</th>
        </tr>
        <c:forEach var="utilisateur" items="${listeUtilisateurs}">
            <tr>
                <td>${utilisateur.nom}</td>
                <td>${utilisateur.prenom}</td>
                <td>${utilisateur.sexe}</td>
                <td>${utilisateur.codePostal}</td>
                <td>
                    <c:forEach var="transport" items="${utilisateur.transports}">
                        ${transport}<br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="formulaire.jsp">Ajouter un autre utilisateur</a>
</body>
</html>
