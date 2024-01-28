#!/bin/bash

DEUXC_HOME=$HOME/.deux

if [ ! -d $DEUXC_HOME ]
then
    mkdir $DEUXC_HOME
fi

cp $PWD/build/deuxc.jar $DEUXC_HOME/deuxc.jar

# create launcher
LAUNCHER=$HOME/.functions.d/deuxc.sh

touch $LAUNCHER

echo '
#!/bin/bash

function deuxc {
    java -jar $HOME/.deux/deuxc.jar $@
}
' > $LAUNCHER

chmod +x $LAUNCHER