[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
<h1 align="center" style="font-weight: bold;">Password secure</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]

<h1 id="description-pt-br">Glossário / Glossary</h1>

- [🇧🇷 Descrição](#description-pt-br)
- [Requisitos](#requisites-pt-br)
- [Instalação](#install-pt-br)
- [Como utilizar](#usage-pt-br)
- [🇺🇸 Description](#description-en-us)
- [Requisites](#requisites-en-us)
- [Installation](#install-en-us)
- [How to use](#usage-en-us)

<h1 id="description-pt-br">🇧🇷 Descrição</h1>

Esse projeto foi desenvolvido como uma solução do desafio de backend proposto pela comunidade [Back-End Brasil](https://github.com/backend-br), 
a descrição do problema com a proposta de solução pode ser encontrado [aqui](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

<h1 id="requisites-pt-br">Requisitos</h1>

- [Java 24](https://www.oracle.com/br/java/technologies/downloads/)

<h1 id="install-pt-br">Instalação</h1>

1. Realize o clone do repositório na sua máquina;
2. Verifique se as dependências no arquivo [pom](./pom.xml) foram adicionados corretamente no projeto, caso não, 
execute o comando `mvn clean install`;
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

<h1 id="usage-pt-br">Como utilizar</h1>

A aplicação espera receber uma requisição no seguinte formato: 

<h3 id="get-suppliers">POST /validate-password</h3>

#### REQUEST

```json
{
  "password": "Sample-pa$$word123"
}
```

#### RESPONSE

```json
{
  "password": "Sample-pa$$word123"
}
```

A senha será validada a partir dos seguintes parâmetros: 
- Tamanho da senha (Padrão: 8 caracteres);
- Quantidade miníma de letras maiúsculas na senha (Padrão: 1 caractere);
- Quantidade miníma de letras minúsculas na senha (Padrão: 1 caractere);
- Quantidade miníma de números na senha (Padrão: 1 caractere);
- Quantidade miníma de caracteres especiais na senha (Padrão: 1 caractere).

Os valores padrão podem ser alterados na classe [Password](./src/main/java/com/luq/secure_password/domain/Password.java), 
atualizando as variáveis MINIMAL_LENGTH, MINIMAL_UPPERCASE, MINIMAL_LOWERCASE, MINIMAL_DIGITS e MINIMAL_SPECIAL_CHARS.

Caso a senha validada for segura, a própria senha será retornada com um código de status 200, indicando sucesso, como no exemplo acima.

Se a senha não for segura, será retornado um erro 400 e os critérios que não forem atendidos serão indicados no campo _message_, como no exemplo abaixo:

<h3 id="get-suppliers">POST /validate-password</h3>

#### REQUEST

```json
{
  "password": "weakpas"
}
```

#### RESPONSE

```json
{
  "timestamp": "2025-09-24T19:17:31.362+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed due to following problems: Password have not enough length expected (8 expected); Password expect at least 1 upper case character(s); Password expect at least 1 digit(s); Password expect at least 1 special character(s);",
  "path": "/validate-password"
}
```
---

<h1 id="description-en-us">🇺🇸 Description</h1>

This project was developed as a solution for backend challenge handed by community [Back-End Brasil](https://github.com/backend-br),
problem's description with solution proposal can be found [here](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md). 

<h1 id="requisites-en-us">Requisites</h1>

- [Java 24](https://www.oracle.com/br/java/technologies/downloads/)

<h1 id="install-en-us">Installation</h1>

1. Clone repository on your desktop;
2. Verify if project's dependencies on [pom](./pom.xml) file were correctly added, if not, run the command `mvn clean install`;
3. Run command `mvn spring-boot:run` to start application.

<h1 id="usage-en-us">How to use</h1>

Application wait to receive a request on following format:

<h3 id="get-suppliers">POST /validate-password</h3>

#### REQUEST

```json
{
  "password": "Sample-pa$$word123"
}
```

#### RESPONSE

```json
{
  "password": "Sample-pa$$word123"
}
```

Password will be validated from the following parameters:
- Password Length (Default: 8 characters);
- Minimal amount of uppercase characters in password (Default: 1 character);
- Minimal amount of lowercase characters in password (Default: 1 character);
- Minimal amount of digits in password (Default: 1 character);
- Minimal amount of special characters in password (Default: 1 character).

Default values can be changed on [Password](./src/main/java/com/luq/secure_password/domain/Password.java) class,
updating variables MINIMAL_LENGTH, MINIMAL_UPPERCASE, MINIMAL_LOWERCASE, MINIMAL_DIGITS e MINIMAL_SPECIAL_CHARS.

If validated password is safe, the same password will be returned with a 200 status code, suggesting success, just like example above

If password isn't safe, will be returned an error 400 and criteria that weren't fulfilled will be shown on field message, like exemplo bellow.

<h3 id="get-suppliers">POST /validate-password</h3>

#### REQUEST

```json
{
  "password": "weakpas"
}
```

#### RESPONSE

```json
{
  "timestamp": "2025-09-24T19:17:31.362+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed due to following problems: Password have not enough length expected (8 expected); Password expect at least 1 upper case character(s); Password expect at least 1 digit(s); Password expect at least 1 special character(s);",
  "path": "/validate-password"
}
```