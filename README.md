# Spring Boot GCP Secret Manager Demo

Este projeto é uma demonstração de como integrar uma aplicação **Spring Boot (Java 21)** com o **Google Cloud Secret Manager**.

O objetivo principal é demonstrar diferentes maneiras de recuperar segredos armazenados na nuvem de forma segura, evitando chaves e senhas hardcoded no código fonte.

## 🚀 O que este projeto faz

A aplicação demonstra a recuperação de segredos de três maneiras distintas:
1.  **Spring Config Import**: Importando segredos diretamente para as propriedades da aplicação via `application.yaml` (ex: `sm://database-password`).
2.  **Anotação @Value**: Injetando segredos diretamente em campos Java usando a sintaxe `sm://`.
3.  **SecretManagerTemplate**: Recuperando segredos programaticamente usando o template fornecido pelo Spring Cloud GCP.

Ao iniciar, a aplicação imprime no console os valores recuperados (apenas para fins de demonstração).

## 🛠️ Pré-requisitos

* Java 21
* Uma conta no Google Cloud Platform (GCP)
* GCP CLI (opcional, mas recomendado)

## ☁️ Configuração no Google Cloud Platform (GCP)

Para que este projeto funcione, você precisa configurar o ambiente na GCP:

### 1. Criar um Projeto e Habilitar API
1.  Crie um projeto no console do GCP.
2.  Habilite a API **Secret Manager API**.

### 2. Criar o Segredo
O código espera um segredo específico. Siga estes passos:
1.  Vá para **Segurança** > **Secret Manager**.
2.  Crie um novo segredo chamado `database-password`.
3.  Adicione um valor de versão ao segredo (ex: `minha-senha-super-secreta`).

### 3. Configurar Permissões (IAM)
A aplicação precisa de permissão para ler os segredos.
1.  Crie uma **Service Account** (Conta de Serviço) no IAM.
2.  Conceda a essa conta o papel (Role) de:
    * `Secret Manager Secret Accessor` (Acessador de segredos do Secret Manager).

### 4. Gerar Chave de Acesso
1.  Na conta de serviço criada, vá em "Chaves" (Keys).
2.  Adicione uma nova chave do tipo **JSON**.
3.  O download do arquivo `.json` começará automaticamente. Guarde este arquivo em um local seguro na sua máquina.

## 🔑 Autenticação Local (GOOGLE_APPLICATION_CREDENTIALS)

Para rodar a aplicação localmente, o SDK do Google precisa saber qual credencial usar. A maneira padrão e recomendada é através da variável de ambiente `GOOGLE_APPLICATION_CREDENTIALS`.

Você **DEVE** configurar essa variável apontando para o caminho do arquivo JSON que você baixou no passo anterior.

### Linux / macOS
```bash
export GOOGLE_APPLICATION_CREDENTIALS="/caminho/absoluto/para/sua-chave-gcp.json"