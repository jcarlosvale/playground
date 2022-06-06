# GraphQL

## Links

- https://www.apollographql.com/docs/apollo-server/

## Instalando

```javascript
λ pnpm --filter @dev-demands/server install apollo-server graphql
...
λ pnpm --filter @dev-demands/server i -D nodemon
```
* package.json to run Nodemon

```javascript
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev": "nodemon -r esm .",
    "start": "node -r esm ."
  }
```
```javascript
λ pnpm --filter @dev-demands/server run dev
```
