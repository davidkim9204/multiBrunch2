package controller;

import controller.action.Action;
import controller.action.RestaurantCheckPassFormAction;
import controller.action.RestaurantDeleteAction;
import controller.action.RestaurantListAction;
import controller.action.RestaurantUpdateAction;
import controller.action.RestaurantUpdateFormAction;
import controller.action.RestaurantViewAction;
import controller.action.RestaurantWriteAction;
import controller.action.RestaurantWriteFormAction;
import controller.action.CommentDeleteAction;
import controller.action.CommentWriteAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		/* 추가된 부분 */
		if (command.equals("Restaurant_list")) {
			action = new RestaurantListAction();
		} else if (command.equals("Restaurant_write_form")) {
			action = new RestaurantWriteFormAction();
		} else if (command.equals("Restaurant_write")) {
			action = new RestaurantWriteAction();
		} else if (command.equals("Restaurant_view")) {
			action = new RestaurantViewAction();
		} else if (command.equals("Restaurant_check_pass_form")) {
			action = new RestaurantCheckPassFormAction();
		} else if (command.equals("Restaurant_update_form")) {
			action = new RestaurantUpdateFormAction();
		} else if (command.equals("Restaurant_update")) {
			action = new RestaurantUpdateAction();
		} else if (command.equals("Restaurant_delete")) {
			action = new RestaurantDeleteAction();
		}
		else if(command.equals("commentWrite")){
			action = new CommentWriteAction();
		}
		else if(command.equals("commentDelete")){
			action = new CommentDeleteAction();
		}
		return action;
	}
}
