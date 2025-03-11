package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.BoardRepleDto;

@Mapper
public interface BoardRepleMapper {
	public void insertReple(BoardRepleDto dto);
	public List<BoardRepleDto> getRepleByIdx(int idx);
	public BoardRepleDto getSelectData(int num);
	public String getPhoto(int num);
	public void deleteBoardReple(int num);
	public void updateReple(BoardRepleDto dto);
}
