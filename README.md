# 🇧🇷 Introdução
Esse projeto foi desenvolvido como uma solução do desafio de backend proposto pela comunidade [Back-End Brasil](https://github.com/backend-br), 
a descrição do problema com a proposta de solução pode ser encontrado [aqui](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

# Instalação
1. Realize o clone do repositório na sua máquina;
2. Verifique se as dependências no arquivo [pom](./pom.xml) foram adicionados corretamente no projeto, caso não, 
execute o comando `mvn clean install`;
3. Execute o comando `mvn spring-boot:run`.

# Como utilizar
A aplicação espera receber uma requisição POST com uma string que será validada em um JSON com a chave _password_.

A senha será validada a partir dos seguintes parâmetros: 
- Tamanho da senha (Padrão: 8 caracteres);
- Quantidade miníma de letras maiúsculas na senha (Padrão: 1 caractere);
- Quantidade miníma de letras minúsculas na senha (Padrão: 1 caractere);
- Quantidade miníma de números na senha (Padrão: 1 caractere);
- Quantidade miníma de caracteres especiais na senha (Padrão: 1 caractere).

Os valores padrão podem ser alterados na classe [Password](./src/main/java/com/luq/secure_password/domain/Password.java), 
atualizando as variáveis MINIMAL_LENGTH, MINIMAL_UPPERCASE, MINIMAL_LOWERCASE, MINIMAL_DIGITS e MINIMAL_SPECIAL_CHARS.

Caso a senha validada for segura, a própria senha será retornada com um código de status 200, indicando sucesso.

Se a senha não for segura, será retornado um erro 400 e os critérios que não forem atendidos serão indicados no campo _message_.

---

# 🇺🇸 Introduction
This project was developed as a solution for backend challenge handed by community [Back-End Brasil](https://github.com/backend-br),
problem's description with solution proposal can be found [here](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md). 

# Installation
1. Clone repository on your desktop;
2. Verify if project's dependencies on [pom](./pom.xml) file were correctly added, if not, run the command `mvn clean install`;
3. Run command `mvn spring-boot:run`.

# How to use
Application wait to receive a POST request with password that will be validated in a JSON containing a string with key _password_.

Password will be validated from the following parameters:
- Password Length (Default: 8 characters);
- Minimal amount of uppercase characters in password (Default: 1 character);
- Minimal amount of lowercase characters in password (Default: 1 character);
- Minimal amount of digits in password (Default: 1 character);
- Minimal amount of special characters in password (Default: 1 character).

Default values can be changed on [Password](./src/main/java/com/luq/secure_password/domain/Password.java) class, 
updating variables MINIMAL_LENGTH, MINIMAL_UPPERCASE, MINIMAL_LOWERCASE, MINIMAL_DIGITS e MINIMAL_SPECIAL_CHARS.

If validated password is safe, the same password will be returned with a 200 status code, suggesting success.

If password isn't safe, will be returned an error 400 and criteria that weren't fulfilled will be shown on field message. 