#wolfbeacon-server

####Contains all code and RESTful API's relating to the server currently hosted on Heroku.

##Using the API

#####Note: OAuth2 authentication required. Login from `/oauth2callback` to make API calls.

###Hackathon Endpoint
`/api/v1/hackathon/list`

*Updated every 6 hours from [Hackalist](www.hackalist.org)*

#####Parameters:
* `start-date` (*yyyy-MM-dd*): Returns all the hackathons *after* this date. Eg: *start-date=2015-10-10*

* `end-date` (*yyyy-MM-dd*): Returns all the hackathons *before* this date. Eg: *end-date=2015-12-10*

* `sort-by` (*Date, Distance*): Returns all the results sorted according to this parameter (All hackathons returned in *datewise ascending order by default)*

 * `distance` (*latitude, longitude*): *sort-by=distance&latitude=19.1231&longitude=45.1231`*

#####Example: [https://wolfbeacon.herokuapp.com/api/v1/hackathon/list?start-date=2016-01-01&end-date=2016-01-30&sort-by=distance&latitude=40.7127837&longitude=-74.00594130000002](https://wolfbeacon.herokuapp.com/api/v1/hackathon/list?start-date=2016-01-01&end-date=2016-01-30&sort-by=distance&latitude=40.7127837&longitude=-74.00594130000002)

#####Output:
```
{
  ...
    {
    "id": 20160916552226390,
    "title": "Hack the North",
    "eventLink": "https://hackthenorth.com/",
    "startDate": "2016-09-15",
    "endDate": "2016-09-17",
    "lastUpdatedDate": "2016-11-13T00:00:00.000+0000",
    "year": 2016,
    "location": "Waterloo, ON, Canada",
    "host": "Hack the North",
    "length": 36,
    "size": "1000",
    "travel": true,
    "prize": true,
    "highSchoolers": true,
    "cost": "free",
    "facebookLink": "https://www.facebook.com/hackthenorth",
    "twitterLink": "https://twitter.com/hackthenorth",
    "googlePlusLink": "",
    "imageLink": "https://scontent.xx.fbcdn.net/v/t1.0-1/p100x100/13501875_1423460301013883_426092165374437510_n.png?oh=23ff635c68eee2faa74b376adc7982fd&oe=58CE1F88",
    "latitude": 43.4642578,
    "longitude": -80.5204096,
    "notes": ""
    },
  ...
}
```


##Setting up locally:

####Dependencies: [Java 8](https://www.java.com/en/download/), [MySQL](http://dev.mysql.com/doc/refman/5.7/en/installing.html), [Maven](https://maven.apache.org/download.cgi).

* `git clone https://github.com/wolfbeacon/5_server`
* Download the configuration files and place them in `src/main/resources`. Change the configuration in *application.properties* and the path to the '.p12' file in *gitkit-server-config.json*

* Building and installing: `
mvn jetty:run -Dorg.eclipse.jetty.annotations.maxWait=120`


#####[Server Configuration Files](https://www.dropbox.com/s/hlr83gg9nn0t78b/wolfbeacon_5_server_config_files_priviliged.tar.gz?dl=0) , [Local Configuration Files](https://www.dropbox.com/s/hi68iz7d7ovd4a6/wolfbeacon_5_local_config_files.tar.gz?dl=0) (Both only available to privileged members. Contact Wolfbeacon admin for info)


##Working with the repository:
* Your master branch should point to `origin/master`. 

* **NEVER EVER WORK ON master**. Keep the master branch updated with upstream `git pull upstream master`. It's only to be used a reference/starting point.

* In reference to the above point, create a different branch for the issue you are working on off your master branch like `git checkout -b username-work`.

* Whenever you begin work, be sure to `git pull --rebase upstream master`. 

* When you have completed, `git push origin username-work` and issue a PR to `wolfbeacon/5_server`. 

* Incase you have a PR pending on this branch , checkout to your local master branch, checkout another work branch and work there. Needless to say, `git pull --rebase upstream master` is always important.
