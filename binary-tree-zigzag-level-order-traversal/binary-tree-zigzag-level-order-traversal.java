        Stack<TreeNode> s2=new Stack<TreeNode>();
        
        s1.push(root);
        
        while(!s1.empty() || !s2.empty()) {
             
            while(!s1.empty()){
                TreeNode temp=s1.peek();
                s1.pop();
                
                    level.add(temp.val);
                
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
            }
            if(!level.isEmpty())
                result.add(new ArrayList<>(level));
            level.clear();
            while(!s2.empty()){
                TreeNode temp=s2.peek();
                s2.pop();
                
                
                    level.add(temp.val);
                
                
                if(temp.right!=null)
                    s1.push(temp.right);
                
                if(temp.left!=null)
                    s1.push(temp.left);
                
            }
            if(!level.isEmpty())
                result.add(new ArrayList<>(level));
            level.clear();
        }
        return result;
    }
}
