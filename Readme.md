     Users :
        Endpoints :
            POST /auth/signin : Créer un compte normal avec "email", "password", "phonenumber", "name"
            POST /auth/login : Se connecter avec "email", "password"

    Event :
        Endpoints :
            GET /event: Tous les events.
            GET /event/{uuid}: Event en fonction de son id.

    Cart :
        Endpoints :
            GET /cart: Tous les paniers si admin
            GET /cart/{uuid}: Un panier en fonction de son id
            POST /cart: Commencer un panier
            PUT /cart/{uuid}: Modifier totalement un panier
            PATCH /cart/{uuid}/price: Modifier le prix à payer total
            PATCH /cart/{uuid}/tickets: Modifier les tickets dans le panier
            PATCH /cart/{uuid}/pay: Payer un panier/créer son historique/supprimer les billets concernés
            DELETE /cart/{uuid}: Annuler un panier

    History:
        Endpoints Admin:
            GET /history: tous les historiques des utilisateurs
            DELETE /history/{uuid}: supprimer un historique
            PUT /history/{uuid}: remplacer les infos d'un historique 
            PATCH /history/price: changer le prix payé d'un historique
        Endpoints Buyer:
            GET /history/{uuid}: Un historique d'achat selon son id
            POST /history: Créer un historique de panier

    Ticket:
        Endpoints :
            GET /ticket: voir billets dispos
            GET /ticket/find/{uuid}: recuperer un billet
            GET /ticket/count/{uuid}: nombre de places d'un event
        Endpoints Admin:
            POST /ticket: ajouter un ticket pour un event
            DELETE /ticket/{uuid}: supprimer un ticket
            PUT /ticket/{uuid}: modifier un ticket
            PATCH /ticket/{uuid}/price: modifier le prix d'un ticket
            PATCH /ticket/{uuid}/buyer: modifier l'acheteur