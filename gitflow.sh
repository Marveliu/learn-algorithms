# !/bin/bash                # 指定shell类型

function clean(){
  find . -name "*.class"  | xargs rm -f

}

run(){
    
    echo $@

	if [ $1 == "push" ]; then
        git add .
        if [ -z $2 ]; then
            echo "commit message cannot be null"
        else
            clean
            git commit -m$2
            git push
        fi    
	elif [ $1 == "clean" ]; then
        echo "rm *.class"
		clean
    fi
}

run $@
