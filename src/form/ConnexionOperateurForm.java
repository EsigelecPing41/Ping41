package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import Modele.Operateur;

public final class ConnexionOperateurForm {
    private static final String CHAMP_LOGIN  = "login";
    private static final String CHAMP_PASS   = "password";
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    private Map<String, String> valeurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public boolean connecterUtilisateur( HttpServletRequest request ) {
    	erreurs.clear();
    	/* Récupération des champs du formulaire */
        String login = getValeurChamp( request, CHAMP_LOGIN );
        String password = getValeurChamp( request, CHAMP_PASS );

        
        /* Validation du champ login. */
        try {
            validationLogin( login );
            setValeur( CHAMP_LOGIN, login );
        } catch ( Exception e ) {
            setErreur( CHAMP_LOGIN, e.getMessage() );
        }
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( password );
            setValeur( CHAMP_PASS, password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }        
        System.out.println(erreurs.toString());
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succes de la connexion.";
            return true;
        } else {
            resultat = "Echec de la connexion.";
            return false;
        }        
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationLogin( String login ) throws Exception {
    	if ( login == null ) {
    		throw new Exception( "Le champs login est nul" );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
    /*
     * Ajoute la valeur du champs correspondant a la map des valeurs
     */
    private void setValeur( String champ, String message ) {
        valeurs.put( champ, message );
    }
    
    /*
     * Ajoute la valeur du champs correspondant a la map des valeurs
     */
    public String getValeur( String champ) {
        return valeurs.get( champ);
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}