# COMANDOS FLYWAY
```sql
mvn flyway:migrate #Executa todas as migrações pendentes no banco de dados
mvn flyway:clean #Remove todos os objetos (tabelas, views, procedures, triggers, ...) no esquema do banco de dados configurado. Útil para reinicializar o banco de dados, mas deve ser usado com cuidado
mvn flyway:info #Exibe o status atual das migrações no banco de dados, incluindo quais migrações foram aplicadas, quais estão pendentes e quais falharam
mvn flyway:validate #Valida as migrações aplicadas contra as migrações disponíveis para garantir que nenhuma delas foi modificada desde que foram aplicadas.
mvn flyway:baseline #Cria a linha de base para um esquema existente com o estado inicial. Útil quando se integra o Flyway em um esquema de banco de dados já existente.
mvn flyway:repair #Repara a tabela de histórico de migrações do Flyway, removendo entradas incorretas e corrigindo checksums.
```

# COMANDO PERSONALIZADO DE MIGRATION
```xml
<profiles>
	<profile>
		<id>applyDbMigration</id>
		<build>
			<plugins>
				<plugin>
					<groupId>org.codehaus.mojo</groupId>
					<artifactId>exec-maven-plugin</artifactId>
					<version>3.0.0</version>
					<executions>
						<execution>
							<goals>
								<goal>exec</goal>
							</goals>
						</execution>
					</executions>
					<configuration>
						<executable>mvn</executable>
						<arguments>
							<argument>flyway:migrate</argument>
						</arguments>
					</configuration>
				</plugin>
			</plugins>
		</build>
	</profile>
</profiles>
```

Para executar, basta digitar no terminal: "mvn -P applyDbMigration exec:exec"
