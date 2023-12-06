FROM node:18-alpine

RUN mkdir -p /client-app
WORKDIR /client-app

COPY . /client-app

EXPOSE 3000

RUN npm install
RUN npm run build

CMD ["npm", "run", "preview"]