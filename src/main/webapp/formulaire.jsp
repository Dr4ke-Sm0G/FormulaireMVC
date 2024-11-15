<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Formulaire</title>
</head>
<body>
    <h2>Formulaire de saisie</h2>
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>
    <form action="FormController" method="post">
        Nom: <input type="text" name="nom" /><br/><br/>
        Prénom: <input type="text" name="prenom" /><br/><br/>
        Sexe:
        <input type="radio" name="sexe" value="Homme" /> Homme
        <input type="radio" name="sexe" value="Femme" /> Femme<br/><br/>
        Code Postal: <input type="text" name="codePostal" /><br/><br/>
        Transports:
        <select name="transports" multiple>
            <option value="Voiture">Voiture</option>
            <option value="Vélo">Vélo</option>
            <option value="Bus">Bus</option>
            <option value="Train">Train</option>
        </select><br/><br/>
        <input type="submit" value="Envoyer" />
    </form>
</body>
</html>
