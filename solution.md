# sample-rest-api

* User login is based on spring security
* All pages are secured behind the login
* User name and password are the following `user@password`
* Locale is part of the request
* Currency formating is based on the request information
* Not really clear what the API should return (where is the data?)
* Returned information is configured as a list on the `application.yml`
* AJAX parsing includes validation and error handling
* Short animation for `Loading` during ajax request
* Because there is no real logic on the Controller, there is no need to create a service for processing the requests
    * The data returned is basically a configuration property
    * I included a list of 5 entries, in order to see the returned data changing on the UI
    * The history includes separated data for both currencies
    * In case of errors, the returned JSON is formated for better visibility
* No clear definition of the CI/CD
    * The application is build/tested using GitHub Actions
    * No definition for the deployment, therefore no specific GHE Action
* IP functionality not clear