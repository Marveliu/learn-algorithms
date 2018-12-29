# !/bin/bash                # 指定shell类型

function clean(){
  find . -name "*.class"  | xargs rm -f

}

run(){
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
        cd workspace
        mv Solution.java Solution.java.tmp
        cp Solution.java.back Solution.java
        cd ..
		clean
    elif [ $1 == "save" ]; then
        echo "save solution.class"
        # 统计数目
        cd leetcode
        num=`ls -l |grep "^-"|wc -l`
        echo ${num}
        cd ..
        let num++
        cp ./workspace/Solution.java ./leetcode/${num}.java
    else  $1 == "clear"
        clean
    fi
}

run $@
