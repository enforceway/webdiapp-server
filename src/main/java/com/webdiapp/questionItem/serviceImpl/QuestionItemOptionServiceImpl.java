//package com.webdiapp.questionItem.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import com.webdiapp.questionItem.entities.QuestionItemOption;
//import com.webdiapp.questionItem.mapper.QuestionItemOptionDAO;
//import com.webdiapp.questionItem.service.QuestionItemOptionService;
//import com.webdiapp.questionaire.vo.QuestionOptionRVO;
//
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class QuestionItemOptionServiceImpl implements QuestionItemOptionService {
//
//	@Resource
//	private QuestionItemOptionDAO questionItemDao;
//
//	@Override
//	public List<QuestionOptionRVO> getList(int questionItemId) {
//		List<QuestionItemOption> rvs = this.questionItemDao.getList(questionItemId);
//		List<QuestionOptionRVO> res = new ArrayList<>(rvs.size());
//		for(QuestionItemOption rvo : rvs) {
//			res.add(new QuestionOptionRVO(rvo));
//		}
//		return res;
//	}
//
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//    @Override
//    public int delete(int[] ids) {
//        return 0;
//    }
//
//    @Override
//	public int insert(QuestionOptionRVO entity) {
//		QuestionItemOption optionItem = new QuestionItemOption();
//		optionItem.setId(entity.getId());
//		optionItem.setQuestionItemId(entity.getQuestionItemId());
//		optionItem.setOptionContent(entity.getOptionContent());
//		optionItem.setSelected(entity.getSelected());
//
//		optionItem.setCreationTimestamp(entity.getCreationTimestamp());
//		optionItem.setLastupdateTimestamp(entity.getLastupdateTimestamp());
//		optionItem.setCreationUser(entity.getCreationUser());
//		optionItem.setLastupdateUser(entity.getLastupdateUser());
//		int res = this.questionItemDao.insert(optionItem);
//		entity.setId(optionItem.getId());
//		return res;
//	}
//
//	@Override
//	public int removeQuestionItemOptionsByQuestionItemIds(int[] questionIds, int questionaireId) {
//		return 0;
//	}
//
//	@Override
//	public int removeQuestionItemsByQuestionId(int[] questionItemIds, int questionId) {
//		return 0;
//	}
//}
