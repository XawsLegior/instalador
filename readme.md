<img src="https://github.com/XawsLegior/instalador/blob/master/prints/print1.png" width="500"/>

<a href="https://github.com/XawsLegior/instalador/blob/master/Instalador/install.exe" target="_blank"> Você pode baixar o instalador para testar clicando aqui! </a>
<br><br>
<p>⚠️ Esse projeto não gera o .exe final!!! Trata-se de um instalador com visual já feito e que pode ser personalizado, você ainda precisa de outro software para gerar o .exe self-extracting.</p>
<br>
<h2> Configuração </h2>
<p> Para gerar um executável usando esse projeto você só precisa seguir os passos:</p>
<p> 1º - Tenha alguma IDE java (Usei IntelliJ). </p>
<p> 2º - Configure informações sobre seu projeto em > src/main/resources/com/worrigan/instalador/software > config.ini  </p>
<p> 3º - Configure a janela de licenças > src/main/resources/com/worrigan/instalador/software > licença.html  </p>
<p> 4º - Compile seu projeto real no formato.zip e coloque em > src/main/resources/com/worrigan/instalador/software/ </p>
<p> 5º - Gere seu .jar e use algum programa self-extracting como o Winrar para gerar o .exe! </p>
<br><br>
<p> Para passar imagem na tela de licença, informe dentro de chaves {}, a pasta path fica em /com/worrigan/instalador/</p>
<p> Nesse caso para informar a imagem logo.png, que está dentro da pasta /com/worrigan/instalador/imagens, ficaria assim: </p>
<p> {imagens/logo.png} </p>

<br>
<h3> Jdk utilizado: <a href="https://www.azul.com/downloads/?version=java-17-lts&os=windows&architecture=x86-32-bit&package=jdk-fx&show-old-builds=true"> JDK Zulu FX 17.0.5_x32 </a> </h3

<img src="https://github.com/XawsLegior/instalador/blob/master/prints/print2.png" width="500"/>
<img src="https://github.com/XawsLegior/instalador/blob/master/prints/print3.png" width="500"/>
