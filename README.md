# Sistema de Gestão de Expedientes — Secretaria Distrital de Mogovolas

**Versão 2.0.0 — projecto académico estruturado para GitHub**

Sistema web para automatizar o ciclo de vida dos expedientes administrativos: entrada, classificação, tramitação, recepção, despacho, anexos, arquivo, auditoria e relatórios. O controlo de acesso é baseado em **RBAC (Role-Based Access Control)**, com permissões aplicadas no servidor e na API REST.

## Arquitectura
- Java 17 + Spring Boot 3.5.6
- Spring Security + RBAC
- Spring Data JPA + PostgreSQL 16
- Thymeleaf + Bootstrap 5 + CSS responsivo
- API REST em `/api/**`
- Docker Compose
- JUnit 5 + Mockito
- Armazenamento local de anexos, limite de 10 MB

## Funcionalidades
1. Autenticação e sessões seguras.
2. RBAC com papéis e permissões.
3. CRUD administrativo de utilizadores, sectores e papéis/permissões.
4. Registo, pesquisa e consulta de expedientes.
5. Tramitação entre sectores.
6. Recepção formal da tramitação.
7. Despachos com utilizador e data.
8. Arquivo de expedientes.
9. Upload/download de anexos.
10. Auditoria de operações críticas.
11. Dashboard e indicadores.
12. API REST para integração.
13. Documentação UML.
14. Dados de demonstração.

## Execução com Docker
```bash
git clone https://github.com/ldaniel2-alt/Disciplina-Engenharia-de-Software.git
cd Disciplina-Engenharia-de-Software
ADMIN_PASSWORD='defina-uma-palavra-passe-forte' docker compose up --build
```
Abrir `http://localhost:8080`.

## Execução local
Criar a base `expedientes_mogovolas`, configurar `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` e, opcionalmente, `ADMIN_PASSWORD`; depois:
```bash
cd backend
mvn clean test
mvn spring-boot:run
```

## Conta inicial
O utilizador `admin` é criado automaticamente na primeira execução. A palavra-passe vem de `ADMIN_PASSWORD`; se a variável não for definida, a aplicação usa um valor temporário que **deve ser alterado imediatamente**.

## API principal
- `GET /api/dashboard`
- `GET /api/expedientes?q=...`
- `POST /api/expedientes`
- `GET /api/expedientes/{id}`
- `POST /api/expedientes/{id}/tramitar?sectorDestino=...`
- `POST /api/expedientes/{id}/receber`
- `POST /api/expedientes/{id}/despacho?texto=...`
- `POST /api/expedientes/{id}/arquivar`
- `POST /api/expedientes/{id}/anexos`
- `GET /api/anexos/{id}/download`
- `GET /api/utilizadores`, `/api/papeis`, `/api/permissoes`, `/api/sectores`, `/api/auditoria`
- Administração: `/api/admin/**`

## Papéis
ADMIN, SECRETARIA, CHEFE_SECTOR, SECRETARIO_PERMANENTE, ARQUIVISTA e AUDITOR.

## Segurança
BCrypt, `@PreAuthorize`, CSRF para interface web, mitigação de session fixation, contas activas/bloqueadas, auditoria com IP/data/utilizador e nomes físicos de anexos com UUID.

## Estrutura
```text
backend/       aplicação Spring Boot
  src/main/java/.../{config,controller,entity,repository,security,service}
  src/main/resources/{templates,static}
  src/test/java/...
database/      documentação do modelo relacional
docs/uml/      PlantUML
docker-compose.yml
.github/       CI com Maven test
```

## Nota
Versão preparada para demonstração e avaliação académica. Para produção institucional recomenda-se Flyway/Liquibase, object storage, antivírus, gestão de segredos, HTTPS, MFA, rate limiting, backups e revisão formal dos perfis.
