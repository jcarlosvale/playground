# Node

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

