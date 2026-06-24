# Moderation Service

O **Moderation Service** é o microsserviço encarregado de garantir a conformidade do conteúdo dos comentários.

## ⚙️ Funcionalidades

- Análise de texto para detecção de palavras proibidas.
- Retorno imediato de aprovação ou rejeição com o motivo.
- Endpoint REST otimizado para chamadas síncronas.

## 🧠 Regras de Moderação

Atualmente, o serviço rejeita qualquer comentário que contenha as seguintes palavras (case-insensitive):

- `ódio`
- `xingamento`

## 🛠️ Endpoints

| Método | Endpoint        | Descrição                                        |
| :----- | :-------------- | :----------------------------------------------- |
| `POST` | `/api/moderate` | Recebe um texto e retorna o status da aprovação. |

### Exemplo de Payload de Entrada

```json
{
  "text": "Este é um comentário de teste",
  "commentId": "unique-uuid"
}
```

### Exemplo de Payload de Saída (Aprovado)

```json
{
  "approved": true,
  "reason": "Comment approved"
}
```
