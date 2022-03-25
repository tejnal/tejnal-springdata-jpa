# Application note
==> Step up docker 
==> set up postgres database. We can get it from the Docker Hub. But we need to create a volume for store data.
docker create -v /var/lib/postgresql/data --name PostgresData alpine
==>  we create the database and do the port mapping 
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d --volumes-from PostgresData postgres
==> add postgres required config in application.properties 
==> Download DBeaver [ https://dbeaver.io/download/] db connection client 
==> Run your application [ build will automatically create schema for you from your entity classes]
==> Run [mvn package] to have Jar file of the application with libs and dependencies



 
