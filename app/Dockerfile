FROM node:16.20.1-alpine
WORKDIR "/usr/src/app"
COPY "package*.json" ./
RUN npm ci
COPY . .
EXPOSE 3000
CMD ["node","server.js"]
