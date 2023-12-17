class FoodRatings {

     public class Info{
        String food;
        String cuisine;
        int rating;
        public Info(String food,String cuisine,int rating){
            this.food=food;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }
    
    Map<String,PriorityQueue<Info>> cuisineMap=new HashMap<>();
    Map<String, Info> foodMap=new HashMap<>();
     
     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
         for(int i=0; i<foods.length; i++){
            Info combo=new Info(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],combo);
            if(cuisineMap.containsKey(cuisines[i])){
                cuisineMap.get(cuisines[i]).add(combo);
            }
            else{
            PriorityQueue<Info> pq=new PriorityQueue<Info>(new Comparator<Info>(){
                    @Override
                    public int compare(Info a,Info b){
                        int result=b.rating-a.rating;
                        if(result==0){
                            return (a.food).compareTo(b.food);
                        }
                        return result;
                    } 
                }); 
                pq.add(combo);
               cuisineMap.put(cuisines[i],pq);
            }
        }
        
    }
    
    public void changeRating(String food, int newRating) {
         Info prev=foodMap.get(food);
        Info curr= new Info(food,prev.cuisine,newRating);
        foodMap.put(food,curr);
        prev.food="";
        cuisineMap.get(prev.cuisine).add(curr);
       
        
    }
    
    public String highestRated(String cuisine) {
         while( cuisineMap.get(cuisine).peek().food.equals("")){
            cuisineMap.get(cuisine).remove();
        }
        return cuisineMap.get(cuisine).peek().food;
       
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */