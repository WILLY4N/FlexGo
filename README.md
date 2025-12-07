# ⛽ FlexGo - Calculadora de Combustível

<img width="500" height="500" alt="0_ic_launcher" src="https://github.com/user-attachments/assets/f82fce8b-2c06-4982-9e8b-5fcae65834e9" />

![1_br edu utfpr flexgo](https://github.com/user-attachments/assets/cb3ceaad-d35c-4338-b0bb-02d2754faaf0)

![4_br edu utfpr flexgo](https://github.com/user-attachments/assets/588927e3-b12b-47f0-9968-85782b9bbcd5)

## 🛠️ Sobre o Projeto
O **FlexGo** é um aplicativo Android, desenvolvido como projeto de conclusão da disciplina de **Android Básico** na Pós-Graduação em Programação para Dispositivos Móveis, da **UTFPR** (Universidade Tecnológica Federal do Paraná).
Seu objetivo é ajudar motoristas de veículos Flex a tomarem a decisão mais econômica sobre qual combustível (Gasolina ou Etanol) utilizar, com base em dados atualizados de preço e eficiência do próprio veículo.

### Como funciona?
O aplicativo utiliza a regra geral de comparar o preço por litro do combustível (R$/L) com o desempenho do veículo por litro de combustível consumido (Km/L). O cálculo é feito da seguinte forma:

$$
\text{Performance} = \frac{\text{Preço do combustível}}{\text{Desempenho}}
$$

Se **'Performance Gasolina'** for menor que **'Performance Etanol'**, a Gasolina é recomendada; caso contrário, o Etanol é a melhor opção.

## ✨ Funcionalidades

* **Entrada de Dados:** Campos para inserção do preço do Etanol e da Gasolina e inserção do consumo de Etanol e Gasolina.
* **Validação de Campos Obrigatórios e Cálculo:** Ao clicar no botão **Calcular** é realizada a validação de preenchimento de campos obrigatórios e cálculo para recomendação de combustível.
* **Recomendação:** Exibe uma mensagem indicando qual combustível é o mais rentável, além da apresentação de memória de cálculo utilizada na comparação dos dados.

## 💻 Tecnologias Utilizadas

* **Linguagem de Programação:** Kotlin
* **Ambiente de Desenvolvimento:** Android Studio
* **Framework:** Android SDK
* **Conceitos Implementados:**
    * Criação de Layouts com `ConstraintLayout`, `ScrollView` e `ListView`
    * Utilização de `TextInputLayout` e `EditText`  (para entrada de dados)
    * Manipulação de `TextView` (para exibição de resultados)
    * Rotação de Tela, Ciclo de Vida da Activity, Aplicação de Temas Light e Dark
    * Tratamento de eventos, validação de dados e lógica de cálculo em Kotlin.

## ⚙️ Instalação e Execução

Para rodar este projeto localmente, siga os passos abaixo:

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/WILLY4N/FlexGo.git
    ```
2.  **Abra no Android Studio:** Abra a pasta clonada como um projeto Android no Android Studio.
3.  **Execute:** Selecione um emulador ou conecte um dispositivo físico e clique em `Run` (o ícone de play verde).

## 🎓 Sobre a Disciplina

Este projeto foi desenvolvido como requisito final para aprovação na disciplina de:

* **Android Básico**
* **Pós-Graduação:** Programação para Dispositivos Móveis
* **Instituição:** **UTFPR** - Universidade Tecnológica Federal do Paraná

## 🤝 Contato
Se você tiver alguma dúvida ou sugestão sobre o projeto, entre em contato:
* **LinkedIn:** https://www.linkedin.com/in/willyan-patrykc/

---
