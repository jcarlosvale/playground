# TypeScript

## Commands:
* initialize a npm empty package (*package.json*)
```json
npm init -y

Wrote to C:\TypeScript\package.json:

{
  "name": "typescript",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}
```

* install typescript
```json
npm install --save-dev typescript
or
npm i -D typescript

added 1 package, and audited 2 packages in 3s

found 0 vulnerabilities
```

* typescript configuration
```json
npx tsc --init

Created a new tsconfig.json with:
                                                                                                         TS
  target: es2016
  module: commonjs
  strict: true
  esModuleInterop: true
  skipLibCheck: true
  forceConsistentCasingInFileNames: true


You can learn more at https://aka.ms/tsconfig.json
```

* compile ts
```
npx tsc
```

* modify your `package.json` to compile using `npm`:
  * add "build"
```json
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "build": "tsc"
```
```
npm run build
```

* uses `tsconfig.json` to modify the project configurations like:
  * "rootDir": "./src"
  * "outDir": "./build"
  * "noEmitOnError": true

## Data Types

### string

```ts
let nome: string;

nome = 'João';

function nomeCompleto(nome: string, sobrenome: string) {
  return nome + ' ' + sobrenome;
}

nomeCompleto('João', 'Silva');
```

### number

```ts
let idade: number;

idade = 25;

function somar(a: number, b: number) {
    return a + b;
}

somar(1,1);
somar(2,4);
```

### boolean

```ts
let active: boolean;

active = true;

function verificarAtivo(ativo: boolean) {
    if (active) {
        return 'Ativo';
    } else {
        return 'Inativo';
    }
}

verificarAtivo(false);
```

### array

```ts
const nomes: string[] = ['João', 'Maria', 'Pedro'];

function printNames(nomes: string[]) {
  return `nomes: ${nomes.join(', ')}`;
}

console.log(printNames(nomes));
```

### tuple

```ts
const pessoas: [string, string, string] = ['João', 'Maria', 'Pedro'];

const joao: [string, number] = ['João', 25];

const maria: [string, number] = ['Maria', 20];
```

### enum

```ts
enum Profiles{
    admin,
    editor, 
    user
}

enum Cores {
  red = '\u001b[31m',
  black = '\u001b[30m',
}

const usuario = {
    level: Profiles.admin
}

console.log(usuario);
```

### other types
* **any**
* **unknown**
* **undefined** 
* **null**
* **object**

References:
[Typescript Lang](https://www.typescriptlang.org/)