# Node

* [GitHub](https://github.com/jcarlosvale/client-server-example)

## Initial Steps

* create project
```javascript
λ npm init
This utility will walk you through creating a package.json file.
It only covers the most common items, and tries to guess sensible defaults.

See `npm help init` for definitive documentation on these fields
and exactly what they do.

Use `npm install <pkg>` afterwards to install a package and
save it as a dependency in the package.json file.

Press ^C at any time to quit.
package name: (client-server-example)
version: (1.0.0)
description:
entry point: (index.js) src/main.js
test command:
git repository: https://github.com/jcarlosvale/client-server-example.git
keywords:
author: Joao Vale
license: (ISC)
About to write to C:\Pessoal\Projects\client-server-example\package.json:

{
  "name": "client-server-example",
  "version": "1.0.0",
  "description": "",
  "main": "src/main.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "repository": {
    "type": "git",
    "url": "git+https://github.com/jcarlosvale/client-server-example.git"
  },
  "author": "Joao Vale",
  "license": "ISC",
  "bugs": {
    "url": "https://github.com/jcarlosvale/client-server-example/issues"
  },
  "homepage": "https://github.com/jcarlosvale/client-server-example#readme"
}
```

* install **ECMAScript** module
```javascript
λ npm i -D esm

added 1 package, and audited 2 packages in 1s

found 0 vulnerabilities
```

* modify the _package.json
  * add _**start**_ script command
```javascript
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "node -r esm ."
  },
```

* create in the project:
  * **_"./src/main.js_**

```javascript
console.log("Hello World!");
```

* run project
  * **_npm run start_**

## Server node

```javascript
import { createServer} from 'http';
import { readFile } from 'fs';
import { resolve } from 'path';
import { parse } from 'querystring';

const server = createServer((req, res) => {
    switch (req.url) {
        case '/status': {
            res.writeHead(200, {'Content-Type': 'text/json'});
            res.write(
                JSON.stringify({
                    status: 'ok'
                })
            );
            res.end();
            return
        }
        case '/sign-in': {
            const filePath = resolve(__dirname, './pages/sign-in.html');
            readFile(filePath, (err, data) => {
                if (err) {
                    res.writeHead(500, {'Content-Type': 'text/plain'});
                    res.write(err.message);
                    res.end();
                    return
                }
                res.writeHead(200, {'Content-Type': 'text/html'});
                res.write(data);
                res.end();
            });
            return;
        }
        case '/home': {
            const filePath = resolve(__dirname, './pages/home.html');
            readFile(filePath, (err, data) => {
                if (err) {
                    res.writeHead(500, {'Content-Type': 'text/plain'});
                    res.write(err.message);
                    res.end();
                    return
                }
                res.writeHead(200, {'Content-Type': 'text/html'});
                res.write(data);
                res.end();
            });
            return;
        } 
        case '/authenticate': {
            let data = '';
            req.on('data', (chunk) => {
                data += chunk;
            });
            req.on('end', () => {
                console.log(parse(data));
                res.writeHead(301, {
                    Location: '/home'
                });
                res.end();
            });
            return;
        } 
        default: {
            res.writeHead(404, 'Service Not Found');
            res.end();
            return
        }
    }
});


const PORT = process.env.PORT ? parseInt(process.env.PORT) : 8000;
const HOSTNAME = process.env.HOSTNAME || '127.0.0.1';


server.listen(PORT, HOSTNAME, () => {
        console.log(`Server listening on http://${HOSTNAME}:${PORT}`);
});
```

## pnpm

* install
```javascript
npm i -g pnpm

pnpm -init
```

* modify _package.json_
```javascript
 {
  "name": "@dev-demands/root",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "MIT"
}
```

* create _pnpm-workspaces.yaml_
```yaml
packages:
  - 'packages/**'
```

* run
```javascript
λ pnpm i
```
* install Server

```javascript
λ pnpm i --filter @dev-demands/server
```

* run server

```javascript
pnpm --filter @dev-demands/server run start
```

* creating React project
```javascript
λ pnpx create-react-app packages\web\
...
λ pnpm i --filter @dev-demands/web
...
λ pnpm --filter @dev-demands/server i express
...
λ pnpm --filter @dev-demands/server i cors
```

# Express

## Project

![Project](.\img\express.png)

* main.js
```javascript
import express, { response } from 'express';
import cors from 'cors';

const server = express();

server.get('/status', (_, response) => {
    response.send({
        status: 'ok'
    });
});

const enableCors = cors({origin: 'http://localhost:3000'})

server
.options('/authenticate', enableCors)
.post('/authenticate', enableCors, express.json(), (request, response) => {
        console.log(request.body.email + ' ' + request.body.password);
        response.send({
            Okay: true,
        });
    });

const PORT = process.env.PORT ? parseInt(process.env.PORT) : 8000;
const HOSTNAME = process.env.HOSTNAME || '127.0.0.1';


server.listen(PORT, HOSTNAME, () => {
        console.log(`Server listening on http://${HOSTNAME}:${PORT}`);
});
```

* SignIn.js
```javascript
import React from 'react';

export default function SignIn() {
  const [email, setEmail] = React.useState('');
  const [password, setPassword] = React.useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    fetch('http://127.0.0.1:8000/authenticate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email,
        password}),
    })
            .then(response => response.json())
            .then((data)=>{
              console.log('success! ', data);
            })
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  return (
          <form action="/authenticate" method="POST" onSubmit={handleSubmit}>
            <fieldset>
              <label htmlFor="email">E-mail</label>
              <input
                      id="email"
                      type="email"
                      value={email}
                      onChange={handleEmailChange}
                      inputMode="email"
                      autoComplete="username"/>
            </fieldset>
            <fieldset>
              <label htmlFor="password">Password</label>
              <input
                      id="password"
                      type="password"
                      value={password}
                      onChange={handlePasswordChange}
                      autoComplete="current-password"/>
            </fieldset>
            <button type="submit">Login</button>
          </form>
  );
} 
```
