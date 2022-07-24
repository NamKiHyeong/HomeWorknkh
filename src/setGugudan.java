//											공백	개수
//2 * 1 = 2										1
//2  *  2  =  4									2
//2   *   3   =   6								3
//2    *    4    =    8							4
//2     *     5     =     10					5
//2      *      6      =      12				6
//2       *       7       =       14			7
//2        *        8        =        16		8
//2         *         9         =         18	9

//함수명	setGugudan
//setGugudan은 리턴값이 없다
//setGugudan은 putNum의 매개변수만 받는다
//
//
//getGugudan
//getGugudan은 문자열을 반환해야 한다
//
//
//getGugudan을 통해 받은 내용을 출력한다

public class setGugudan {
	
	public void putNum(int dan) {
		for (int i = 1; i <= 9; i++) {
			String str = " ";
				System.out.println(dan + str +" X " + i + str + " = " + str +(dan * i));

		}
		System.out.println("출력좀 하게 해주세요");
		}
	
	}







