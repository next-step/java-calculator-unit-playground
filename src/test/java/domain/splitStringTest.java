//package domain;
//
//
//import org.junit.jupiter.api.Test;
//import view.OutputView;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//
//class outputviewTest {
//
//
//    @Test
//    void 스플릿_세미콜론_작동_테스트() {
//        OutputView outputView = new OutputView();
//        outputView.splitStr("//;\n1;2;3");
//        int[] expected = {1, 2, 3};
//        assertArrayEquals(expected, outputView.intArr);
//    }
//
//    @Test
//    void 스플릿_쉼표를이용한_작동_테스트() {
//        OutputView outputView = new OutputView();
//        outputView.splitStr("//,\n1,2,3");
//
//        int[] expected = {1, 2, 3};
//        assertArrayEquals(expected, outputView.intArr);
//    }
//
//
//    @Test
//    void 예외처리_테스트() {
//        OutputView outputView = new OutputView();
//        outputView.splitStr("//;\n1,2,a");
//    }
//}
//
//
