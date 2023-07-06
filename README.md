# Simple blog app on spring-boot with java <br />
run "docker-compose build" to build the image and then "docker-compose up" to run the container <br />
frontend is accesible in a browser at http://localhost:3000 <br />
backend port 8080 is exposed for external testing outside docker. <br />
endpoints:  <br />
GET /api/posts - to get all posts <br />
POST /api/post - body with data the post <br />
DELETE /api/post - with body with the post ID and code do delete <br />
PUT /api/post - same as delete but with eventual updated data <br />
I didn't implement this update method to the frontend <br />
<br />
There is a docker image as database but without attached volume, so db is not persistent and is empty with a new container.<br />
