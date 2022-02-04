# user-rewards
creating user and reading all users

creating user:
==================>
sending the request payload via post man by hitting the url http://localhost:8181/user/saveUser.
the request going to usercontroller class coresponding the path /saveUser
@PostMapping("/saveUser")
	public User createNewUser(@RequestBody User user) {
		User saveUser=null;
		if(user!= null) {
			saveUser=userService.createNewUser(user);
		}else {
			controllerLogger.error("user object is empty "+user);
		}
		return saveUser;
		
	}
  
  controller talk to service layer method to which is  responsible to call tak to repository layer to save
  
  public User createNewUser(User user) {
		User savedUser=null;
		
		if(user!=null) {
			 savedUser=userRepository.save(user);
		}
		else {
			serviceLogger.error("user object is empty "+user);
		}
	return savedUser;
		
	}
  
  creating reward for user:
  =============================>
  
  based on the user id we are going to create reward for user
  in reward payload providing userId if the user is existing with that userId
  then isert the reward for the user
  flow of execution for rewards
  rewardscontroller class is recieve the request payload and  the controller  method createUserReward() which is responsible to talk to service layer
 
 @PostMapping("/saveReward")
	public Reward createUserReward(@RequestBody Reward reward) {
		Reward saveReward =null;
		if(reward!=null) {
			
			saveReward=rewardsService.createRewardForUser(reward);
		}else {
			logger.error("reward object is empty "+reward);
		}		
		return saveReward;	
	}
  
  service layer method createRewardForUser() is responsible to talk with repository layer ,
  in this method first we need to check weather the user is existing in the user table or not,
  if it is available then go ahead to create reward for user by  calling  repository save() method. 
  public Reward createRewardForUser(Reward reward) {
		
		Reward savedReward=null;
		User user=userRepository.findById(reward.getUserId()).get();
		if(user!=null) {
			savedReward=rewardsRepository.save(reward);
			return savedReward;	
		}
		else {
			logger.error("User not exist with this id to create a reward "+reward.getUserId());
		}
		return savedReward;
	}


