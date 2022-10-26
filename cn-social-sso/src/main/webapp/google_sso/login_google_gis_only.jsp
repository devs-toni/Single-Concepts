<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
  <!-- 
  	Ejemplo de GIS-Only  
  	https://developers.google.com/identity/oauth2/web/guides/migration-to-gis#gis-only 
  -->
  <meta name="google-signin-client_id" content="774301494621-a58tbbvne72ndnbokllloqrpnkurqj98.apps.googleusercontent.com">
  <script src="https://accounts.google.com/gsi/client"  async defer></script>
  </head>
  <body>
    <script>
      var client;
      var access_token;

      function initClient() {
        client = google.accounts.oauth2.initTokenClient({
          client_id: 'id',
          scope: 'https://www.googleapis.com/auth/calendar.readonly \
                  https://www.googleapis.com/auth/contacts.readonly',
          callback: (tokenResponse) => {
            access_token = tokenResponse.access_token;
          },
        });
      }
      function getToken() {
        client.requestAccessToken();
      }
      function revokeToken() {
        google.accounts.oauth2.revoke(access_token, () => {console.log('access token revoked')});
      }
      function loadCalendar() {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'https://www.googleapis.com/calendar/v3/calendars/primary/events');
        xhr.setRequestHeader('Authorization', 'Bearer ' + access_token);
        xhr.send();
      }
    </script>
    <h1>Google Identity Services Authorization Token model</h1>
    <button onclick="getToken();">Get access token</button><br><br>
    <button onclick="loadCalendar();">Load Calendar</button><br><br>
    <button onclick="revokeToken();">Revoke token</button>
  </body>
</html>

</body>
</html>