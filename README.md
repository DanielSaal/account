##Desafio:
Efetuar o desenvolvimento de uma api REST em Java com o seguinte endpoint:

**Conta**
``` json
{
"id" : "String", // gerado automaticamente ao criar
"numero": "String", // Somente digitos e no máximo 6 caracteres
"agencia": "String", // Somente digitos e no máximo 4 caracteres
"cpf": "String", // Somente digitos e no máximo 11 caracteres
"status": "Boolean", // Default ativo
"dataCriacao": LocalDate,
"dataAtualizacao" LocalDate,
}
```
**GET /contas**
> Lista todas contas cadastradas -> Possivel paginar

**GET /contas/{id}**
> Retorna uma conta especifica pelo ID

**POST /contas**
> Salva uma conta na base de dados

**PUT /contas/{id}**
> Atualiza um conta

**DELETE /contas/{id}**
> Faz o delete lógico da conta (status = false)
