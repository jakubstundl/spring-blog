# Simple Blog App on Spring Boot with Java

## Instructions
1. Run `docker-compose build` to build the image.
2. Run `docker-compose up` to run the container.

## Access
- Frontend is accessible in a browser at [http://localhost:3000](http://localhost:3000).
- Backend port 8080 is exposed for external testing outside of Docker.

## Endpoints
- **GET /api/posts**: Retrieve all posts.
- **POST /api/post**: Create a new post by sending a request body with the post data.
- **DELETE /api/post**: Delete a post by sending a request body with the post ID and the deletion/update code.
- **PUT /api/post**: Update a post by sending a request body with the post ID, the deletion/update code and any updated data.

Note: The update method has not been implemented in the frontend.

## Database
- There is a Docker image as the database, but it doesn't have an attached volume.
- The database is not persistent and will be empty with a new container.

