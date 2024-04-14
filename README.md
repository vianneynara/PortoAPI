# Portfolio API

A simple API to manage my portfolio projects.

## Latest Version

- `v1.x`: Implementing basic CRUD operations for projects.

## Features

- Create, read, update and delete projects.
- Store project information in a PostgreSQL database.

### Upcoming features

- Add user and authentication.

## Endpoints

`GET /api/v1/projects`
Get all projects.

`GET /api/v1/projects/:id`
Get a project by id.

`POST /api/v1/projects`
Create a new project.

`PUT /api/v1/projects/:id`
Update a project by id.

`DELETE /api/v1/projects/:id`
Delete a project by id.

### Examples

```http
POST http://localhost:8080/api/v1/projects
Content-Type: application/json

{
  "name": "Kyou Bot",
  "description": "Python discord bot wrapped using disnake. Built for Kyou's Asobi Playground Discord Server.",
  "imageUrl": "https://media.discordapp.net/attachments/967356760690159667/983676601894043648/ServerIcon.png?ex=66278b39&is=66151639&hm=cad93c5084bad56049a2276742b75a58a31abb8800b6c7262c06d672c8e2c247&=&format=webp&quality=lossless&width=481&height=481",
  "tags": [
    "Python", "Disnake", "Discord Bot", "Kyou", "Asobi Playground"
  ],
  "projectUrl": "https://github.com/vianneynara/kyou-bot",
  "ownerId": 1
}
```

```http
GET http://localhost:8080/api/v1/projects
```

```http
GET http://localhost:8080/api/v1/projects/6
```

```http
PUT http://localhost:8080/api/v1/projects/1
Content-Type: application/json

{
  "description": "Python discord bot wrapped using disnake.",
  "projectUrl": ""
}
```

```http
DELETE http://localhost:8080/api/v1/projects/1
```

## Technologies

- Java Spring Boot
- PostgreSQL