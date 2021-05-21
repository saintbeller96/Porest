#live-server-docker-file
FROM node:16-alpine

WORKDIR /app


COPY ./video_chat /app

run npm install

CMD ["npm", "start"]

EXPOSE 3000
