# Ambientes Android

O modulo `:app` possui a dimensao de flavors `environment`. Ambiente e build type sao independentes: cada flavor tem variantes `Debug` e `Release`.

| Flavor | Application ID | Nome no dispositivo | Versao inicial |
| --- | --- | --- | --- |
| dev | com.avanade.carteiradigital.dev | Carteira Digital (DEV) | 1.0-dev |
| stg | com.avanade.carteiradigital.stg | Carteira Digital (STG) | 1.0-stg |
| prod | com.avanade.carteiradigital | Carteira Digital | 1.0 |

Os identificadores diferentes permitem instalar os tres ambientes no mesmo dispositivo, com dados privados separados pelo Android. `BuildConfig.ENVIRONMENT` expoe `dev`, `stg` ou `prod` ao codigo, sem derivar o ambiente de `DEBUG`.

## Uso

No Android Studio, selecionar `devDebug`, `stgDebug` ou `prodDebug` em Build Variants. Na raiz do projeto, em PowerShell:

```powershell
.\gradlew.bat :app:assembleDevDebug :app:assembleStgDebug :app:assembleProdDebug
```

Testes unitarios de ambiente, pacote e versao:

```powershell
.\gradlew.bat :app:testDevDebugUnitTest :app:testStgDebugUnitTest :app:testProdDebugUnitTest
```

Validacao de analise estatica:

```powershell
.\gradlew.bat :app:lintDevDebug :app:lintStgDebug :app:lintProdDebug
```

Testes instrumentados de pacote e rotulo, com dispositivo/emulador conectado:

```powershell
.\gradlew.bat :app:connectedDevDebugAndroidTest :app:connectedStgDebugAndroidTest :app:connectedProdDebugAndroidTest
```

APKs debug ficam em `app/build/outputs/apk/<flavor>/debug/`. Para compilar release, usar `assembleDevRelease`, `assembleStgRelease` ou `assembleProdRelease`; assinatura e distribuicao de release ainda precisam de configuracao propria. `prodDebug` e uma compilacao depuravel do ambiente prod, nao um artefato de publicacao.

## Limites e seguranca

Nenhum endpoint, segredo, configuracao Firebase ou credencial de assinatura foi acrescentado. Esses valores dependem dos contratos e acessos do projeto. Nao guardar segredos em `BuildConfig`, recursos ou propriedades versionadas: o APK pode ser inspecionado. A separacao dos flavors nao substitui autorizacao e isolamento dos servicos remotos.

Se uma dependencia ou o SDK impedir a compilacao, resolver o erro de ambiente relatado pelo Gradle antes de afirmar que as variantes estao validadas. Os comandos acima descrevem as verificacoes previstas, nao comprovam sua execucao.