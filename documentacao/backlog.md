# Backlog - Carteira Digital

Data: 2026-11-03. Status: proposta para refinamento, nao aprovada para sprint.

## 1. Base e limites da analise

Fonte primaria: [conteudo.txt](conteudo.txt), transcricao fornecida pela usuaria do material "Formacao Mobile - Fase 3". Imagens e prototipo visual nao foram analisados; fidelidade visual nao pode ser validada com esta fonte. O PDF e o PowerPoint nao foram lidos diretamente.

Analise realizada com os agentes solicitados: Maria (requisitos e lacunas), Joao (escopo e prioridades), Wilson (arquitetura, estado do projeto e riscos) e Paula (historias e criterios). O documento consolida essas contribuicoes; propostas de aceite nao equivalem a regras aprovadas pelo negocio.

### Referencias da transcricao

| Fonte | Secao | Localizador |
| --- | --- | --- |
| F02 | Prototipo: jornadas principais | Marcador final 2 |
| F03 | Objetivo, missao, competencias e evidencias | Marcador final 3 |
| F04 | Escopo funcional e desafio de nao duplicidade | Marcador final 4 |
| F05 | Arquitetura e regras do projeto | Marcador final 5 |
| F06 | Roadmap de seis semanas | Marcador final 6 |
| F07 | Semanas 1 e 2: fundacao, arquitetura e UI | Marcador final 7 |
| F08 | Semanas 3 e 4: dados e operacoes | Marcador final 8 |
| F09 | Semanas 5 e 6: qualidade e hardening | Marcador final 9 |
| F10 | Responsabilidades e acompanhamento | Marcador final 10 |
| FDOD | Avaliacao e Definition of Done | Secao final, sem numero visivel |

Os numeros encerram a secao anterior no texto; sao marcadores da transcricao, nao paginas conferidas no PDF.

### Objetivo e escopo

Construir uma carteira digital simulada, com API mockada e dados ficticios, arquitetura multimodulo, operacao offline, seguranca, testes e pipeline de entrega. Demonstrar ausencia de efeitos financeiros duplicados com timeout, desconexao ou retomada do aplicativo (F03-F04).

Fora do escopo comprovado: integracao bancaria real, movimentacao financeira real e infraestrutura de producao bancaria. Nao ha exigencia comprovada de backend .NET, Azure ou BradsCore. A escolha de hospedagem do mock permanece aberta.

Requisitos detalhados: acesso, home, extrato, transferencia, pagamento QR simulado, agendamento, cancelamento e engenharia. Splash/onboarding, cadastro, recuperacao de senha, gastos por categoria, notificacoes, perfil e configuracoes sao citados em F02, mas sem detalhamento equivalente em F04. Permanecem no E08, pendentes de confirmacao, nao descartados.

### Ponto de partida verificado por Wilson

Projeto Android com somente modulo `:app`, Activity inicial Compose com "Hello Android", catalogo de versoes existente, camadas `data`, `domain` e `presetation` vazias e testes de exemplo. Nao foram demonstradas features financeiras, flavors, persistencia, rede ou sincronizacao implementados. Compatibilidade das ferramentas e compilacao nao foram verificadas. Antes de persistir dados sensiveis, revisar permissoes e regras de backup do manifesto existente.

## 2. Priorizacao e epicos

P0 = fundacao, fluxo central ou risco critico. P1 = completude funcional dependente da fundacao; nao significa opcional. A definir = escopo insuficientemente detalhado. A ordem e proposta por valor e dependencias; nao foi calculado RICE sem dados de alcance, impacto e esforco.

| Epico | Resultado esperado | Prioridade | Itens | Fonte |
| --- | --- | --- | --- | --- |
| E01 Fundacao | Base modular, ambientes e validacao inicial reproduziveis | P0 | H00, H01, H02 | F05-F07 |
| E02 Acesso e experiencia | Primeira feature vertical com acesso protegido e UI previsivel | P0 | H03, HU01-HU05 | F04-F07 |
| E03 Conta, extrato e offline | Historico consultavel com estado local e atualidade identificados | P0 | HU06-HU09 | F04, F08 |
| E04 Transferencia confiavel | Uma intencao gera no maximo um efeito financeiro simulado | P0 | H04, H05, HU10-HU12 | F04, F08-F09 |
| E05 Pagamentos | QR, agendamento e cancelamento simulados | P1 | HU13-HU15 | F04 |
| E06 Qualidade e entrega | Evidencias automatizadas, observabilidade e APK rastreavel | P0 transversal | H06, H07, H09 | F03, F07-F09 |
| E07 Hardening e defesa | Resiliencia demonstrada e entrega reproduzivel | P0 | H08 | F09, FDOD |
| E08 Jornadas do prototipo | Confirmar e detalhar jornadas apenas citadas | A definir | HU16-HU21 | F02 |

Todos os itens estao em Draft, exceto E08, em A refinar. Pontos, tamanho, sprint e responsaveis individuais: a definir com a equipe. Habilitadores nao sao apresentados como historias de valor direto ao usuario. Cada criterio e uma proposta verificavel para refinamento. O DoD e os controles transversais da secao 5 aplicam-se a todos os itens pertinentes.

## 3. Backlog detalhado

### E01 - Fundacao

#### H00 - Contratos e decisoes iniciais
P0 | Draft | Dependencias: nenhuma | Fonte: F04-F05, F07-F08.

Como equipe, queremos contratos explicitos para implementar e testar a simulacao sem pressupostos divergentes.

- Dado o escopo F04, quando refinar o mock, entao documentar modelos, erros, identidades, autorizacao, paginacao, filtros e consulta de resultado de operacoes.
- Dadas as regras monetarias e temporais ainda abertas, quando revisar os contratos, entao registrar decisoes ou bloqueios, sem inventar limites, tarifas ou horario de execucao.
- Dado o requisito de idempotencia, quando definir o contrato, entao especificar escopo/retencao da chave, repeticao de payload e recuperacao de resultado desconhecido.

Testes/evidencias: exemplos de sucesso, rejeicao, indisponibilidade e resposta perdida; revisao de contrato por PO e arquitetura. Componentes: contratos de dominio e mock. Bloqueios: D01-D04.

#### H01 - Modularizacao, build logic e ambientes
P0 | Draft | Dependencias: nenhuma | Fonte: F05-F07.

Como pessoa desenvolvedora, quero modulos e convencoes reutilizaveis para manter dependencias e ambientes explicitos.

- Dado o projeto configurado, quando compilar dev, stg e prod, entao gerar variantes identificaveis com configuracoes segregadas e catalogo de versoes centralizado.
- Dado o grafo aprovado no ADR 001, quando validar dependencias, entao Domain permanecer sem Android Framework e UI sem acesso direto a Room/Retrofit; DTO, Entity e Domain Model sao separados.
- Dada uma dependencia proibida ou configuracao ausente, quando validar a base, entao falhar com diagnostico acionavel, sem usar silenciosamente outro ambiente.

Tarefas: validar matriz Gradle/AGP/Kotlin/JDK/SDK, criar modulos, convention plugins e build logic, compor dependencias e registrar ADR 001/diagrama. Proposta de Wilson: Domain possui interfaces; Data implementa-as, esclarecendo a seta logica Presentation -> Domain -> Data da fonte. Testes: compilacao das variantes, regras arquiteturais e convencoes. Nao impor framework de DI.

#### H02 - Pipeline inicial e protecao de integracao
P0 | Draft | Dependencias: H01 | Fonte: F07, F09.

Como equipe, queremos build, lint e testes no pipeline para detectar regressao antes de integrar.

- Dado um PR valido, quando o pipeline executar, entao publicar resultado de build, lint e testes por variante acordada.
- Dado um teste ou analise obrigatoria com falha, quando tentar integrar, entao a protecao de branch impedir integracao e apontar o check responsavel.
- Dado segredo necessario ao CI, quando executar ou falhar, entao usar armazenamento protegido sem inclui-lo nos logs ou repositorio.

Testes: execucao valida e falha controlada de cada gate; tentativa de merge bloqueada. Dependencia externa: repositorio e permissoes de CI/branch a confirmar. H06 amplia os gates; H09 trata o APK.

### E02 - Acesso e experiencia

#### H03 - Estado, Design System e navegacao
P0 | Draft | Dependencias: H01 | Fonte: F05-F07.

Como equipe, queremos UI unidirecional e componentes acessiveis para manter interacoes previsiveis.

- Dado um Event, quando processado, entao produzir UI State imutavel via StateFlow e Effects transitorios conforme contrato MVI.
- Dados componentes e rotas tipadas, quando navegar e exibir previews, entao preservar estado coerente e sem acesso direto da UI a dados de infraestrutura.
- Dada recomposicao, recriacao de tela ou erro, quando retomar a UI, entao nao repetir comandos financeiros e oferecer o estado de erro recuperavel.

Testes: Use Case, ViewModel e Compose; loading, sucesso, vazio e erro; navegacao e acessibilidade conforme secao 5. Componentes: apresentacao, componentes compartilhados e navegacao. Bloqueio visual: D10; estrutura funcional pode ser refinada sem as imagens.

#### HU01 - Login simulado
P0 | Draft | Dependencias: H00, H03 | Fonte: F04, F07.

Como usuaria, quero autenticar-me na simulacao para acessar minha carteira.

- Dadas credenciais aceitas pelo mock, quando entrar, entao abrir a area autenticada vinculada a identidade correta.
- Dadas credenciais rejeitadas, quando tentar entrar, entao informar erro acessivel e nao criar sessao.
- Dada API indisponivel, quando enviar, entao encerrar loading e permitir recuperacao sem expor credenciais ou fabricar sucesso.

Testes: Use Case, ViewModel, integracao mock e Compose. Componentes: acesso, dominio e repository de sessao. Bloqueio: D01/D05; nao presumir formato de credencial.

#### HU02 - Sessao segura e expirada
P0 | Draft | Dependencias: HU01 | Fonte: F04, F08-F09.

Como usuaria autenticada, quero uma sessao protegida para acessar somente meus dados.

- Dada sessao valida, quando retomar o app, entao aplicar a politica de persistencia e autorizacao aprovada.
- Dada sessao expirada, quando consultar ou enviar operacao protegida, entao impedir acesso e solicitar autenticacao sem retry infinito.
- Dado material de sessao persistido, quando inspecionar armazenamento, backup e logs, entao nao encontrar segredos em claro nem dados de outra identidade.

Testes: expiracao com relogio controlado, retomada, isolamento de contas e armazenamento protegido por chaves Keystore conforme ADR. Componentes: sessao, dados locais e seguranca. Bloqueio: D05.

#### HU03 - Logout
P0 | Draft | Dependencias: HU02 | Fonte: F04; isolamento proposto por Wilson.

Como usuaria autenticada, quero encerrar minha sessao para impedir acessos posteriores por ela.

- Dada sessao ativa, quando sair, entao revogar o acesso local e impedir retorno a telas protegidas sem autenticacao.
- Dado aplicativo encerrado apos logout, quando reabrir, entao nao restaurar indevidamente a sessao anterior.
- Dada operacao pendente, quando sair ou trocar de identidade, entao nao envia-la com credenciais de outra conta e preservar a possibilidade de reconciliacao conforme politica aprovada.

Testes: navegacao, reabertura e, apos H05, logout concorrente com Worker. Componentes: sessao, cache e fila. Bloqueio: D05; politica de descarte/retencao deve ser decidida, nao presumida.

#### HU04 - Biometria e Keystore
P0 | Draft | Dependencias: HU02 | Fonte: F03-F04, F08.

Como usuaria, quero usar biometria para obter acesso autorizado com protecao local.

- Dada biometria disponivel e configurada, quando validar com sucesso, entao liberar somente a acao prevista na politica aprovada.
- Dado cancelamento, bloqueio ou ausencia de biometria, quando tentar, entao manter protecao e oferecer apenas alternativa previamente aprovada.
- Dada chave invalidada ou falha criptografica, quando acessar segredo, entao falhar de modo controlado e exigir recuperacao segura, sem liberar acesso indevido.

Testes: dispositivo/emulador, cancelamento, indisponibilidade e invalidacao de chave; segredos nunca em logs. Componentes: seguranca e acesso. Bloqueio: D05; uso em acesso versus autorizacao de transferencia a confirmar. Biometria nao substitui autorizacao do mock.

#### HU05 - Home da conta
P0 | Draft | Dependencias: HU02, H03, H00 | Fonte: F04, F07.

Como usuaria autenticada, quero consultar saldo, atalhos e ultimas transacoes para acompanhar minha conta.

- Dados registros ficticios da minha conta, quando abrir a home, entao apresentar saldo, atalhos e ultimas transacoes coerentes com o contrato.
- Dada ausencia de transacoes, quando carregar, entao apresentar estado vazio sem inventar movimentacoes.
- Dada falha na consulta, quando carregar, entao mostrar erro recuperavel ou cache identificado apos HU09, nunca saldo zero como substituto silencioso de erro.

Testes: repository, ViewModel, navegacao dos atalhos e Compose. Componentes: conta e consulta de transacoes. Bloqueios: D01/D02/D10.

### E03 - Conta, extrato e offline

#### HU06 - Extrato paginado
P0 | Draft | Dependencias: HU02, H00, H03 | Fonte: F04, F08.

Como usuaria autenticada, quero percorrer meu extrato em paginas para consultar o historico progressivamente.

- Dada proxima pagina disponivel, quando solicita-la, entao acrescentar registros na ordem contratada sem duplicar IDs.
- Dado fim do conjunto ou extrato vazio, quando consultar, entao representar essa condicao sem carregamento infinito.
- Dada falha na pagina seguinte, quando carregar, entao preservar os itens existentes e permitir nova tentativa sem saltar registros.

Testes: paginas repetidas, fronteiras, refresh interrompido e integracao Room/mock. Componentes: Retrofit/OkHttp, repository, Room, mappers DTO/Entity/Domain e apresentacao. Paging 3 e opcao tecnica, nao exigencia da fonte. Bloqueio: D01.

#### HU07 - Busca e filtros do extrato
P0 | Draft | Dependencias: HU06 | Fonte: F04.

Como usuaria, quero buscar e filtrar o extrato para localizar transacoes relevantes.

- Dados campos e combinacoes aprovados, quando aplicar criterios, entao retornar apenas resultados correspondentes e reiniciar a paginacao corretamente.
- Dada consulta sem correspondencias, quando pesquisar, entao apresentar vazio distinto de erro.
- Dada entrada invalida, falha ou busca offline limitada ao cache, quando consultar, entao explicar a condicao sem apresentar resultados parciais como completos.

Testes: combinacoes aprovadas, mudanca rapida de consulta, paginacao filtrada e isolamento entre contas. Componentes: consulta, repository e UI. Bloqueios: D01/D06; campos nao definidos no material.

#### HU08 - Detalhes da transacao
P0 | Draft | Dependencias: HU06 | Fonte: F04.

Como usuaria, quero abrir uma transacao para consultar suas informacoes.

- Dada transacao existente e autorizada, quando seleciona-la, entao exibir os detalhes da identidade correta conforme contrato.
- Dada transacao inexistente ou indisponivel, quando abrir, entao apresentar erro ou indisponibilidade sem dados de outra operacao.
- Dado identificador pertencente a outra conta, quando consulta-lo, entao negar acesso sem revelar seu conteudo.

Testes: navegacao, mappers, identidade, autorizacao e consulta local apos HU09. Componentes: detalhe, dominio e repository. Bloqueio: D01/D10.

#### HU09 - Consulta offline, cache e sincronizacao
P0 | Draft | Dependencias: HU05, HU06 | Fonte: F03, F06, F08-F09.

Como usuaria, quero consultar dados locais e identificar sua atualidade para usar a carteira sem conexao.

- Dado cache existente, quando consultar offline ou apos expirar o TTL, entao manter dados consultaveis e indicar desatualizacao conforme politica aprovada.
- Dado cache vazio offline, quando abrir a consulta, entao distinguir falta de dados locais de saldo zero ou falha de autenticacao.
- Dado retorno da rede ou falha de refresh, quando sincronizar, entao atualizar a fonte local atomicamente quando houver sucesso e preservar dados anteriores quando falhar.

Tarefas: Room como fonte observavel proposta, Retrofit/OkHttp, DataStore para preferencias, mappers, migracoes, TTL com relogio testavel e segregacao por conta/consulta. Testes: repository e banco, migracoes, expiracao nas fronteiras, refresh interrompido e reconexao. DataStore nao e cofre de segredos nem fila. Bloqueio: D06.

### E04 - Transferencia confiavel

#### H04 - Idempotencia no cliente e no mock
P0 | Draft | Dependencias: H00, H01 | Fonte: F04, F08-F09.

Como equipe, queremos identificar e deduplicar cada intencao para impedir efeitos financeiros duplicados.

- Dado commit no mock seguido de perda da resposta, quando repetir a mesma chave e payload, entao recuperar o resultado original com um unico efeito no saldo e extrato.
- Dadas requisicoes concorrentes para a mesma intencao, quando processadas, entao o mock garantir unicidade atomica e resultado coerente.
- Dada chave existente com payload divergente, quando reutiliza-la, entao rejeitar conforme contrato sem novo efeito financeiro.

Tarefas propostas: persistir chave/payload antes do envio; deduplicacao duravel no mock; consultar resultado por identidade; definir retencao de chave. Mock de respostas estaticas, botao desabilitado e trabalho unico do WorkManager nao comprovam essa garantia. Testes: integracao com contagem de lancamentos e saldo, timeout apos commit e concorrencia. Bloqueios: D01/D02.

#### H05 - Fila persistida e retry
P0 | Draft | Dependencias: H04, HU02 | Fonte: F08-F09.

Como usuaria, quero recuperar operacoes pendentes apos interrupcoes para acompanhar seu resultado sem duplicacao.

- Dada intencao persistida, quando houver desconexao e morte do processo, entao recuperar a mesma operacao e chave ao retomar, sem gerar outra intencao.
- Dado timeout com resultado remoto desconhecido, quando WorkManager retomar, entao reconciliar/repetir conforme contrato, mantendo pendente ate resultado autoritativo, sem presumir falha definitiva ou sucesso.
- Dada rejeicao definitiva, sessao expirada ou troca de conta, quando avaliar retry, entao nao reenviar cegamente nem executar sob outra identidade; estados pendente/concluido/falhou permanecem coerentes.

Tarefas: fila Room, recuperacao de pendencias, WorkManager, classificacao de erros, backoff/limites e isolamento por conta. Testes: morte real do processo antes/depois do envio, resposta perdida, retomada concorrente, retorno da rede e logout; simples rotacao nao substitui morte do processo. Bloqueios: D02/D05/D06. Reinicio do dispositivo e force-stop sao cenarios adicionais propostos, nao exigencias explicitas de F04.

#### HU10 - Preparar e validar transferencia
P0 | Draft | Dependencias: HU02, H03, H00 | Fonte: F04, F08.

Como usuaria autenticada, quero informar e validar uma transferencia para revisar uma intencao consistente.

- Dados campos validos segundo contrato aprovado, quando continuar, entao exibir revisao com destinatario e valores correspondentes.
- Dados campos invalidos, quando continuar, entao impedir avanco e associar mensagens acessiveis aos campos.
- Dada alteracao de dados apos revisao, quando prosseguir, entao exigir revisao da nova intencao, sem reutilizar aprovacao anterior.

Testes: Use Case, ViewModel, Compose e fronteiras monetarias aprovadas. Proposta tecnica: representacao monetaria exata, nunca ponto flutuante binario. Limites, saldo insuficiente, campos e arredondamento dependem de D02; nao sao regras ja fornecidas.

#### HU11 - Confirmar transferencia uma unica vez
P0 | Draft | Dependencias: HU10, H04, H05 | Fonte: F04, F08-F09.

Como usuaria, quero confirmar os dados revisados para autorizar uma unica transferencia simulada.

- Dada revisao valida e autorizada, quando confirmar, entao persistir a intencao e exibir pendente/concluido/falhou conforme resultado, atualizando saldo e extrato coerentemente.
- Dados multiplos toques, recomposicao ou timeout, quando confirmar/retomar a mesma intencao, entao nao criar outra operacao nem outro efeito financeiro.
- Dada rejeicao do mock ou resultado desconhecido, quando apresentar o estado, entao distinguir falha definitiva de pendencia e oferecer recuperacao apropriada.

Testes: ponta a ponta no mock, toques concorrentes, timeout apos commit e morte do processo com convergencia apos retomada. Componentes: revisao, Use Case, fila e mock. Bloqueios: D02/D05 para eventual autorizacao biometrica da transferencia.

#### HU12 - Comprovante da transferencia
P0 | Draft | Dependencias: HU11 | Fonte: F02, F04.

Como usuaria, quero consultar o comprovante de uma transferencia concluida para verificar seu resultado.

- Dada conclusao confirmada pelo mock, quando abrir comprovante, entao mostrar dados e identificador da operacao correspondente.
- Dada operacao pendente, falha ou desconhecida, quando consultar, entao nao emitir comprovante de sucesso.
- Dada falha na consulta ou retomada, quando tentar novamente, entao recuperar o mesmo comprovante sem efetuar nova transferencia.

Testes: identidade, estados e recuperacao de leitura. Componentes: comprovante e consulta de operacao. Compartilhamento/exportacao nao esta especificado e nao foi acrescentado. Bloqueios: D01/D10.

### E05 - Pagamentos

#### HU13 - Pagamento por QR simulado
P1 | Draft | Dependencias: HU02, H04, H05, H03 | Fonte: F02, F04.

Como usuaria, quero realizar um pagamento por QR simulado para praticar essa jornada na carteira.

- Dado QR valido segundo formato aprovado, quando revisar e autorizar, entao registrar uma unica operacao e apresentar o resultado correspondente.
- Dado QR invalido ou nao suportado, quando interpreta-lo, entao informar rejeicao sem enviar pagamento.
- Dado timeout ou resposta perdida, quando retomar a mesma intencao, entao aplicar idempotencia e reconciliacao sem duplicar efeito.

Testes: parser segundo contrato, rejeicao, UI e integracao idempotente. Bloqueio: D03; camera versus entrada de valor simulado nao foi definida, nao impor captura por camera.

#### HU14 - Agendar operacao simulada
P1 | Draft | Dependencias: HU02, H04, H05, H03 | Fonte: F02, F04.

Como usuaria, quero agendar uma operacao para acompanhar sua execucao futura simulada.

- Dados operacao e data elegiveis segundo regras aprovadas, quando agendar, entao persistir um unico agendamento consultavel com identidade e estado.
- Dados data ou parametros invalidos, quando enviar, entao rejeitar com mensagem acessivel sem criar agendamento.
- Dada resposta perdida ou retomada do executor, quando repetir a mesma intencao ou executar o agendamento devido, entao nao duplicar agendamento nem efeito financeiro.

Testes: relogio controlado, limites de data/fuso aprovados, persistencia e retomada. Bloqueio: D04; tipo elegivel, precisao de horario e comportamento offline a definir. WorkManager nao promete execucao em horario exato.

#### HU15 - Cancelar agendamento
P1 | Draft | Dependencias: HU14 | Fonte: F04.

Como usuaria, quero cancelar um agendamento elegivel para impedir sua execucao conforme regras acordadas.

- Dado agendamento cancelavel, quando confirmar cancelamento, entao persistir e apresentar o resultado autoritativo.
- Dado estado nao cancelavel ou corrida entre cancelar e executar, quando solicitar, entao apresentar o resultado real sem anunciar sucesso indevido.
- Dada resposta perdida ou repeticao do cancelamento, quando recuperar, entao reconciliar o mesmo pedido sem efeitos conflitantes.

Testes: elegibilidade, concorrencia cancelar/executar e falha de conexao. Componentes: agendamentos, dominio e mock. Bloqueio: D04; cancelamento nao presume estorno de operacao concluida.

### E06 - Qualidade e entrega

#### H06 - Testes, analise estatica e cobertura
P0 transversal | Draft | Dependencias: H02 | Fonte: F03, F07-F09, FDOD.

Como equipe, queremos gates e relatorios verificaveis para detectar regressao e demonstrar qualidade.

- Dado candidato de entrega, quando executar a suite, entao publicar testes de Use Case, ViewModel, repository, banco, integracao e Compose, com rastreabilidade aos criterios.
- Dado codigo com violacao bloqueante no Detekt/Android Lint ou teste falhando, quando validar, entao falhar o gate e explicar a causa.
- Dada cobertura medida, quando publicar, entao informar metrica, modulos, exclusoes e percentual real, sem inflar o resultado com codigo gerado ou somente testes de exemplo.

Testes do gate: sucesso, falha intencional e relatorio abaixo do limiar acordado. Fonte registra 50%; padrao metodologico pede >80%. Resolver D07 antes de configurar aceite final; nao declarar 50% como atendimento ao padrao mais estrito. Kover/JaCoCo e escolha tecnica sujeita a compatibilidade.

#### H07 - Crashlytics e Analytics sem dados sensiveis
P0 transversal | Draft | Dependencias: H02, H00 | Fonte: F09, FDOD.

Como equipe, queremos observar falhas e eventos para diagnosticar a simulacao sem expor dados sensiveis.

- Dado crash controlado em ambiente de teste, quando coleta-lo, entao disponibilizar evidencia identificada pela versao no Crashlytics.
- Dado evento aprovado, quando registra-lo, entao usar esquema permitido no Analytics, segregado por ambiente conforme configuracao aprovada.
- Dados tokens, credenciais, dados pessoais ou payload financeiro/QR, quando ocorrer evento ou falha, entao nao inclui-los em logs, breadcrumbs ou telemetria.

Testes: allowlist, sanitizacao e inspecao de relatorios reais de teste. Dependencias externas: acesso Firebase e politica de coleta, D08/D09. Dados ficticios nao dispensam protecao de segredos.

#### H09 - APK rastreavel e entrega com Firebase
P0 | Draft | Dependencias: H02, H06 | Fonte: F03, F09, FDOD.

Como pessoa avaliadora, quero obter um APK identificavel para instalar e verificar a versao demonstrada.

- Dado pipeline aprovado, quando gerar o APK, entao publicar artefato instalavel com ambiente, versao e commit rastreaveis.
- Dada configuracao de assinatura ou publicacao ausente, quando entregar, entao falhar com diagnostico sem expor segredos nem publicar artefato incorreto.
- Dado o uso do Firebase esclarecido em D08, quando disponibilizar a entrega, entao demonstrar o fluxo aprovado e o acesso dos avaliadores ao APK.

Testes: geracao no CI, instalacao limpa/atualizacao conforme politica e acesso ao artefato. Firebase App Distribution e proposta de distribuicao, nao produto explicitamente nomeado na fonte. Nao presumir que Firebase gera o APK. Credenciais/assinatura em armazenamento protegido do CI.

### E07 - Hardening e defesa

#### H08 - Resiliencia, documentacao e demonstracao final
P0 | Draft | Dependencias: HU03, HU04, HU07, HU08, HU09, HU12, HU13, HU15, H07, H09 | Fonte: F07, F09-F10, FDOD.

Como pessoa avaliadora, quero reproduzir a entrega e entender as decisoes para verificar sua sustentabilidade.

- Dado candidato integrado, quando executar API indisponivel, sessao expirada, cache vazio/antigo, perda de resposta e reconexao, entao obter estados controlados e nenhuma duplicidade de efeitos.
- Dado pacote final, quando seguir README, diagramas, ADRs e roteiro de demonstracao, entao instalar o APK e reproduzir evidencias sem depender de conhecimento oral ou segredos publicados.
- Dado defeito de seguranca, acessibilidade ou regressao critica, quando revisar, entao registrar correcao e repetir o cenario antes do aceite, sem declarar entrega concluida com criterio obrigatorio falhando.

Testes/evidencias: matriz da secao 5; inspecao de backup/permissoes/armazenamento, TalkBack e fonte ampliada, instalacao e reproducao do README. Entregas: codigo/PRs, APK, README, backlog, diagramas, ADR 001 e demais ADRs, cobertura, pipeline e apresentacao. Jornadas E08 integram o pacote somente apos decisao explicita de escopo, nao por exclusao silenciosa.

### E08 - Jornadas citadas no prototipo

Fonte de todos os itens: F02. Prioridade: a definir. Status: A refinar. Dependencias finais e esforco: pendentes. Os objetivos abaixo sao interpretacoes de trabalho dos nomes das jornadas; nao ha criterios funcionais aprovados. Antes de implementar, preencher cenarios positivos, negativos e testes. Nao presumir canais, dados, permissoes ou comportamento visual sem fonte.

#### HU16 - Splash e onboarding
Como nova usuaria, quero passar pela experiencia inicial para chegar ao acesso a carteira.

Dependencia candidata: H03. Refinar: conteudo, recorrencia, possibilidade de pular e comportamento na retomada. Aceite/testes a definir para primeira abertura, aberturas seguintes e interrupcao; imagens indisponiveis impedem validacao visual.

#### HU17 - Cadastro
Como nova usuaria, quero cadastrar-me para obter acesso a simulacao.

Dependencias candidatas: H00, H03. Refinar: campos, validacoes, duplicidade e confirmacao; nao assumir CPF, e-mail ou SMS. Aceite/testes a definir para cadastro aceito, rejeitado, indisponibilidade e repeticao da solicitacao.

#### HU18 - Recuperacao de senha
Como usuaria, quero recuperar meu acesso para voltar a carteira.

Dependencias candidatas: H00, H03. Refinar: mecanismo, canal, validade e protecao contra enumeracao de contas. Aceite/testes a definir para fluxo valido, expirado/invalido e indisponibilidade, sem pressupor envio de e-mail ou SMS.

#### HU19 - Gastos por categoria
Como usuaria, quero consultar gastos por categoria para compreender sua distribuicao.

Dependencias candidatas: HU06, HU09. Refinar: categorias, classificacao, periodo, agregacao e tratamento de cancelamentos. Aceite/testes a definir para agregacao coerente, dados ausentes, erro e atualidade offline; nao inventar graficos ou regras contabeis.

#### HU20 - Notificacoes
Como usuaria, quero consultar informacoes relevantes da carteira para acompanhar seus eventos.

Dependencias candidatas: H03, HU02. Refinar: eventos, canal local/push/in-app, leitura, autorizacao e permissoes. Aceite/testes a definir para entrega, indisponibilidade, repeticao e permissao negada quando aplicavel; nao assumir uso de FCM.

#### HU21 - Perfil e configuracoes
Como usuaria, quero acessar meu perfil e configuracoes para consultar ou ajustar opcoes autorizadas.

Dependencias candidatas: HU02, H03. Refinar: campos, opcoes editaveis, persistencia e validacoes. Aceite/testes a definir para consulta/alteracao valida, rejeicao, falha de salvamento e isolamento entre contas.

## 4. Decisoes e bloqueios de refinamento

Responsaveis abaixo sao papeis propostos para facilitar a decisao, nao aprovadores ja designados. Nenhuma decisao foi presumida resolvida.

| ID | Decisao pendente | Itens afetados | Papel proposto |
| --- | --- | --- | --- |
| D01 | Contratos mock: autenticacao, modelos, erros, autorizacao, ordem/cursores, filtros e detalhes | H00, HU01-HU08, HU12 | Maria + Wilson + equipe |
| D02 | Campos/validacoes monetarias, representacao, saldo, idempotencia atomica, retencao de chaves e reconciliacao | H04-H05, HU10-HU12 | Maria + Wilson + equipe |
| D03 | Formato e entrada do QR simulado, revisao/autorizacao | HU13 | Maria + Paula |
| D04 | Operacao agendavel, datas/fuso, executor, offline e corrida cancelar/executar | HU14-HU15 | Maria + Wilson |
| D05 | Expiracao/renovacao, biometria/fallback, invalidacao de chave, fila/cache apos logout e troca de conta | HU02-HU04, H05, HU11 | Wilson + Maria |
| D06 | Fonte local, TTL, sincronizacao, busca offline, politicas e limites de retry | HU07, HU09, H05 | Wilson + equipe |
| D07 | Medicao/gate de cobertura: 50% na fonte versus >80% metodologico; escopo, metrica e exclusoes | H06, H09, H08 | Joao + Paula + equipe |
| D08 | Significado de "Pipeline e APK (Utilizar do firebase)", servico de distribuicao e acesso dos avaliadores | H07, H09 | Joao + Wilson |
| D09 | Esquemas Analytics, sanitizacao, configuracoes de ambiente e coleta permitida | H07 | Wilson + equipe |
| D10 | Acesso a imagens/prototipo e criterios visuais/acessiveis aprovados | H03, telas e E08 | Paula + equipe de UX |
| D11 | Inclusao e detalhamento de todas as jornadas E08; nenhuma exclusao automatica | HU16-HU21, H08 | Joao + Maria + Paula |
| D12 | Capacidade, estimativas, decomposicao INVEST e encaixe de pagamentos/E08 no treinamento | Todos | Paula + equipe |

## 5. Verificacao e gates

### Matriz de cenarios criticos

Os testes abaixo sao propostas derivadas dos riscos; devem virar testes executaveis na implementacao, nao foram executados nesta entrega documental.

| Cenario | Resultado verificavel | Cobertura no backlog |
| --- | --- | --- |
| Timeout depois de commit no mock | Uma alteracao de saldo e um lancamento; mesma chave devolve resultado original | H04, H05, HU11 |
| Dois envios concorrentes da mesma intencao | Unicidade atomica no mock, sem efeito financeiro adicional | H04, HU11 |
| Morte do processo antes/depois do envio | Fila e chave preservadas; resultado converge apos retomada | H05, HU11 |
| Oscilacao de rede e retries | Sem duplicacao, sem loop infinito, pendencia distinguivel de falha definitiva | H05, HU09 |
| API indisponivel ou erro de pagina | Cache/itens anteriores preservados, erro recuperavel | HU05-HU09 |
| Cache vazio/antigo e TTL na fronteira | Vazio distinto de erro, dado antigo identificado | HU09 |
| Sessao expirada/logout com Worker ativo | Sem envio por outra identidade, acesso protegido e reconciliacao segura | HU02-HU03, H05 |
| Biometria cancelada/chave invalidada | Nenhum acesso indevido, recuperacao segura | HU04 |
| Cancelar enquanto agendamento executa | Resultado autoritativo, sem sucesso ou estorno inventado | HU14-HU15 |
| Logs, backup e telemetria | Sem tokens, segredos ou dados sensiveis expostos | HU02, H07, H08 |
| TalkBack, foco e fonte ampliada | Jornadas acionaveis, sem cortes, erros/estados anunciados | H03, H08 e telas |
| Gates CI e instalacao do APK | Falha bloqueia integracao; artefato valido identificavel e instalavel | H02, H06, H09 |

### Definition of Ready proposta

- Fonte, beneficio, limites e criterios verificaveis aprovados para o item.
- Pelo menos tres criterios de aceite cobrindo sucesso, falha e limite relevante; E08 ainda nao atende.
- Contratos, modelos, politica offline, seguranca e componentes impactados definidos quando aplicaveis.
- Dependencias e bloqueios resolvidos ou com plano explicito que permita executar o item.
- Imagens/UX disponiveis quando fidelidade visual integrar o aceite; sem afirmar equivalencia visual a partir do texto.
- Equipe valida INVEST e subdivide itens grandes, sobretudo H01, H03, HU09, H05 e H08; habilitadores mantem natureza tecnica.
- Esforco, responsavel e capacidade estimados pela equipe antes de compromisso de sprint.

### Definition of Done

Base FDOD: criterios atendidos; loading/sucesso/vazio/erro; offline quando aplicavel; testes e analise estatica aprovados; nenhuma exposicao de dados sensiveis; acessibilidade; code review; documentacao e demonstracao atualizadas.

Aplicacao proposta dos padroes de qualidade:

- Testes unitarios de regras e estados, integracao de repository/banco/mock e testes Compose das jornadas pertinentes, com evidencias anexadas aos PRs.
- Cobertura de 50% e a referencia explicita F03. O padrao Avanade solicita >80%; registrar a decisao D07 e eventuais desvios antes de aceitar o gate. Nao alterar silenciosamente nenhum limiar nem afirmar conformidade sem medi-lo.
- WCAG AA como referencia de qualidade adicional ao termo "acessibilidade basica" da fonte: contraste minimo 4,5:1 para texto comum, TalkBack, ordem de foco, rotulos, fonte ampliada sem corte e estados nao dependentes apenas de cor. Alvos de toque de pelo menos 48 dp como pratica Android proposta.
- Segredos fora do codigo, autorizacao das consultas/operacoes, TLS nas integracoes remotas, dados de contas segregados, logs estruturados sanitizados e revisao de backup/permissoes. API simulada nao elimina requisitos de seguranca.
- CI aprovado, revisao de codigo e validacao dos criterios pelo papel responsavel. Nao declarar Ready/Done apenas por possuir descricao ou testes de exemplo.

Pesos de avaliacao FDOD: arquitetura 20%; codigo 15%; offline + sync 15%; seguranca 15%; testes 15%; CI/CD 10%; documentacao + defesa 10%. Total 100%. Nao ha nota de corte informada; peso de testes nao e percentual de cobertura.

## 6. Sequencia formativa e acompanhamento

As seis semanas sao o roteiro da fonte F06-F09, nao compromisso de entrega nem estimativa de capacidade. Qualidade, seguranca, documentacao e acessibilidade acompanham cada incremento.

| Semana da fonte | Foco | Sequencia proposta e evidencias |
| --- | --- | --- |
| 1 | Fundacao | H00-H02, refinamento, README, backlog, diagrama, ADR 001 e tres ambientes compilando |
| 2 | Arquitetura + UI | H03, HU01-HU05; primeira feature vertical, previews, testes de Use Case/ViewModel |
| 3 | Dados + offline | HU06-HU09; API, Room/DataStore, modelos, cache, testes de repository/banco |
| 4 | Operacoes seguras | H04-H05, HU10-HU12 e HU04; idempotencia, fila, WorkManager, teste de desconexao |
| 5 | Qualidade + entrega | Consolidar H06-H07 e H09; testes, Detekt/Lint, cobertura, Crashlytics/Analytics, branch protegida e APK |
| 6 | Hardening | H08; falhas, seguranca, acessibilidade, debitos, documentacao e defesa tecnica |

H04/H05 dependem de contratos desenhados desde a fundacao. E05 e funcionalidade explicita, obrigatoria para completude do escopo F04; seu encaixe semanal nao foi definido na fonte e precisa de D12. E08 requer D11 e D12. H08 depende dos pagamentos completos, nao somente dos itens P0; nao reduzir o escopo para caber no calendario sem decisao registrada.

F10: Leonardo atua no ciclo 1 em arquitetura, autenticacao e dominio e revisa dados/Design System; Rafael em Design System, integracao, banco e extrato e revisa arquitetura. As responsabilidades se invertem nas semanas 4 a 6. Ambos implementam, revisam, testam, documentam e apresentam. Essa distribuicao e contexto do treinamento, nao atribuicao automatica deste backlog.

Ritual semanal: estudo dirigido, laboratorio, PR, code review e review tecnica. Check-in: concluido, bloqueios, decisao tecnica, aprendizado, debito e proxima demonstracao.

## 7. Controle de cobertura documental

Rastreabilidade: fonte -> epico -> item -> criterios -> testes/evidencias. Referencias de fonte e dependencias estao no cabecalho de cada item; testes e componentes acompanham sua descricao.

| Area da fonte | Itens principais |
| --- | --- |
| Jornadas adicionais do prototipo | HU16-HU21, D10-D11 |
| Acesso, sessao, logout, biometria | HU01-HU04 |
| Conta e home | HU05 |
| Extrato, busca, filtros e detalhes | HU06-HU08 |
| Offline, cache, fonte de verdade e sincronizacao | HU09, H05 |
| Transferencia, confirmacao, comprovante e nao duplicidade | H04-H05, HU10-HU12 |
| QR, agendamento e cancelamento | HU13-HU15 |
| Multimodulo, camadas, modelos, MVI, DS e navegacao | H00-H01, H03 |
| Seguranca, Keystore e protecao de dados | HU02-HU04, H07-H08 |
| Testes, cobertura, analise estatica, CI e Firebase/APK | H02, H06-H07, H09 |
| Falhas, documentacao, ADRs e defesa tecnica | H08 |
| Roadmap, responsabilidades e avaliacao | Secoes 5-6 |

Entrega atual: backlog documental analisado pelos quatro papeis. Nenhuma feature do aplicativo, teste de aplicativo, pipeline ou APK foi implementado ou validado como parte desta elaboracao.