package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.base

interface Dynamodb {
    fun tableName(): String
    fun partitionKey(): String
}