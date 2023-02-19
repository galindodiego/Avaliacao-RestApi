# Avaliacao-RestApi

![image](https://user-images.githubusercontent.com/106025458/219950144-b75fad4d-39a1-48fe-ad12-c398cf3294ff.png)

Testes realizados com o Postman

### Adicionar Endereço (endereco) [POST /endereco] http://localhost:8080/enderecos
Obs: Deve-se adicionar mais endereços para que seja possivel cadastrar "Pessoa" com mais endereços.

           {
    "logradouro": "Av.Paulista",
    "cep":"08683-150",
    "numero":"314",
    "cidade": "São Paulo" 
    }


### Buscar Endereço (List) [GET /endereco] http://localhost:8080/enderecos

### Adicionar Pessoa (Pessoa) [POST /pessoa] http://localhost:8080/pessoas

##### Cadastro de Pessoa com 1 endereço:
    {
     "nome":"Diego1",
    "dataNascimento":"13/06/1984",
    "enderecoPrincipal": 1,
    "endereco":[{
        "id":1}
     ]
    }

##### Cadastro de Pessoa com 2 endereço:
    {
     "nome":"Diego1",
    "dataNascimento":"13/06/1984",
    "enderecoPrincipal": 1,
    "endereco":[{
        "id":1},
        {
        "id":2
    }]
    }
 
 
 
 ### Buscar Pessoa (List) [GET /pessoas] http://localhost:8080/pessoas
 
 
 ### Buscar PessoaId (pessoaId) [GET /pessoas] http://localhost:8080/pessoas/1

 
 ### Atualizar Pessoa (pessoaId) [PUT /pessoas] http://localhost:8080/pessoas/1
     {
     "nome":"Diego1",
    "dataNascimento":"13/06/1984",
    "enderecoPrincipal": 1,
    "endereco":[{
        "id":1},
        {
        "id":2
    }]
    }

### Deletar Pessoa (pessoaId) [DELETE /pessoas]  http://localhost:8080/pessoas/1


-------------
 1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?
R: Realizar os testes de unidade, integração e regressão, para garantir que o software esteja funcionando corretamente como o esperado.



2.	Em qual etapa da implementação você considera a qualidade de software?
R: Na etapa de diagnóstico, no qual é feito um mapeamento da estrutura organizacional e dos processos, garantindo assim a criação de acordo com o funcionamento da empresa.
