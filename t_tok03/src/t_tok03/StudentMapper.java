package t_tok03;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
	@Select("SELECT * FROM student")
	List<Student> selectStudent();
}
