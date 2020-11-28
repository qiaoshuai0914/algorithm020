学习笔记

###1、深度优先遍历 ； 广度优先遍历
树的前中序遍历是深度优先遍历,根据访问分支顺序不同分为前中序； 
###用递归实现  
模版：
    1。判断递归终止条件
    if(root ==null){
        return;
    }
    2.顺序模版 下面顺序不同则是不同的调用
    root.val
    root.left
    root.right;
###迭代实现
模版：迭代实现深度优先搜索，借助栈；
    1。初始化栈
    while(root!=null||!stack.isEmpty()){
            while(root!=null){
              放入栈
              循环
            }
            循环
    }