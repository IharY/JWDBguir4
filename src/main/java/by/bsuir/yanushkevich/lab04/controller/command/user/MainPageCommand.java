package by.bsuir.yanushkevich.lab04.controller.command.user;

import by.bsuir.yanushkevich.lab04.controller.command.Command;
import by.bsuir.yanushkevich.lab04.controller.command.CommandResult;
import by.bsuir.yanushkevich.lab04.entity.Room;
import by.bsuir.yanushkevich.lab04.exception.ServiceException;
import by.bsuir.yanushkevich.lab04.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> freeRoomList = roomService.findFree();
        request.setAttribute(ROOM_LIST, freeRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}
