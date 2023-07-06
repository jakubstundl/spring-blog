# Simple blog app on spring-boot with java
run "docker-compose build" to build the image and then "docker-compose up" to run the container
frontend is accesible in a browser at http://localhost:3000
backend port 8080 is exposed for external testing outside docker.
endpoints: 
GET /api/posts - to get all posts
POST /api/post - body with data the post
DELETE /api/post - with body with the post ID and code do delete
PUT /api/post - same as delete but with eventual updated data
I didn't implement this update method to the frontend

There is a docker image as database but without attached volume, so db is not persistent and is empty with a new container.
