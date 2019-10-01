# Assignment-Java-1

* This Project implements RESTful API which will call the gitlab and github APIs. API will return the repositories of the respectivve user from respective platform. 
* **Enviroment** :  Apache Tomcat
* **URL** : http://localhost:8080/assignment/rest/user/searchRepos
* **Method** : POST
* **Request body** : 
 ```
    {
      "gitLabUser" : "username",
      "grantType" : "password",
      "gitLabpassword" : "passwordHere",
      "searchLabUser" : "emailHere",
      "searchHubUser": "userNameHere",
      "owned": "true"
    }
```
* **Response body** :
```
{
    "gitLab": [
        {
            "projectId": "14561701",
            "projectName": "Testing-Private",
            "visibility": "private",
            "webUrl": "https://gitlab.com/test/testing-private",
            "gitLabUser": "test@gmail.com"
        },
        {
            "projectId": "14554687",
            "projectName": "Testing-1",
            "visibility": "public",
            "webUrl": "https://gitlab.com/test/testing-1",
            "gitLabUser": "test@gmail.com"
        }
    ],
    "gitHub": [
        {
            "projectId": "211947633",
            "projectName": "Testing-git",
            "visibility": "Public",
            "webUrl": "https://github.com/test/Testing-git",
            "gitHubUser": "test"
        }
    ]
}
```
  
* **Test cases** : Junit test case for the same is under **com.assign.test** package
* **Future enhancment** : 
    1. Pagination for the response.
    2. Security for the API.
    3. Modified generic version of HttpClient used to call gitLab API's (HttpClient needed due to unavailability of official gitlab client libraries).
  
