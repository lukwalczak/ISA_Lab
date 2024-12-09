FROM nginx:1.23.3

LABEL authors="lukaszwalczak"

ENV build_version=""

ENV API_URL=http://simple-rpg-gateway:8080/api

EXPOSE 80

ADD dist/simple-rpg-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
