This application name is Feed Web Service.
The Goal of this application is to be able to distribute data from different feeds including images to clients.
It's based on a Spring Boot Project connected to a PostgreSQL DataBase.

The Web Service contains a batch whose scope is to fetch the data from the external services and to pars and to insert them inside the Database.
This batch is easily configurable modifying the two propertyies inside the application.property file:
- "urisList" contains the uris where to fetch data separated with a comma;
- "pollingCron" contains the cron expression to schedule the batch.

The other purpose of this application is to expose all the data with RESTful services. Currently, there are four main responding paths:
- "/getNewsContainingTitle?title=whatever" that returns the list of news containing the title used as a parameter;
- "getNewsBetweenDates?pubDateStart=02/06/2019 00:00:00&pubDateEnd=02/06/2019 23:45:00" that returns the list of news published in the interval defined by the two dates "pubDateStart" and "pubDateEnd";
- "/getNewsAfterPubDate?pubDate=02/06/2019 00:00:00" that returns the list of news published after the parameter "pubDate";
- "/getAllNews" that return all the news inside the Database.

Notice: The dates must be in the format "dd/MM/yyyy HH:mm:ss" or the application will respond with an error.

Once started, the application will create the database "feed_db" with only one table called "news".
This table will be empty until the batch will insert any data.




