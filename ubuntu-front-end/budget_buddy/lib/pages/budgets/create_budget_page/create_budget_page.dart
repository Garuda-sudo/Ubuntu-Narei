import 'package:budget_buddy/pages/budgets/create_budget_page/budget_parallax_position.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class CreateBudgetPage extends StatefulWidget {
  const CreateBudgetPage({super.key});

  @override
  State<CreateBudgetPage> createState() => _CreateBudgetPageState();
}

class _CreateBudgetPageState extends State<CreateBudgetPage> {
  List<String> images = [
    "/images/background_image_1.jpg",
    "/images/background_image_2.jpg",
    "/images/background_image_3.jpg"
  ];
  double budgetImageTopPosition = 0.0;
  double budgetTreeTopPosition = 0.0;
  double firstScrollBarHeight = 25;
  double secondScrollBarHeight = 25;
  double thirdScrollBarHeight = 25;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: NotificationListener(
          onNotification: (notification) {
            if (notification is ScrollUpdateNotification) {
              if (notification.scrollDelta == null) {
                return true;
              }
              setState(() {
                budgetImageTopPosition -= notification.scrollDelta! / 2.0;
                budgetTreeTopPosition -= notification.scrollDelta! / 1.5;
                //print(notification.scrollDelta);
              });
              if (notification.scrollDelta!.abs() >= 2 &&
                  notification.scrollDelta!.abs() <= 4) {
                setState(() {
                  firstScrollBarHeight = 25;
                  secondScrollBarHeight = 8;
                  thirdScrollBarHeight = 25;
                });
              }
            }
            return true;
          },
          child: Stack(
            children: [
              ParallaxPosition(
                asset: "/images/budget_image.jpg",
                top: budgetImageTopPosition,
                left: 0.0,
                right: 0.0,
              ),
              // ParallaxPosition(
              //   asset: "/images/money_tree_image.png",
              //   top: budgetTreeTopPosition,
              //   left: 0.0,
              //   right: 200.0,
              // ),
              SingleChildScrollView(
                physics: const ClampingScrollPhysics(),
                child: Column(
                  children: [
                    const SizedBox(
                      height: 150,
                    ),
                    Container(
                      height: MediaQuery.of(context).size.height,
                      width: MediaQuery.of(context).size.width,
                      alignment: Alignment.center,
                      child: Container(
                          decoration: const BoxDecoration(
                              image: DecorationImage(
                                  fit: BoxFit.cover,
                                  image: AssetImage(
                                      "/images/background_image_1.jpg"))),
                          child: Container(
                            margin: const EdgeInsets.all(10.0),
                            child: Column(
                              children: [
                                Row(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceBetween,
                                  children: [
                                    Column(
                                      children: [
                                        Container(
                                          width: 150,
                                        )
                                      ],
                                    ),
                                    Column(
                                        children: List.generate(3, (index) {
                                      return AnimatedContainer(
                                        width: 8,
                                        height: firstScrollBarHeight,
                                        decoration: BoxDecoration(
                                            borderRadius:
                                                BorderRadius.circular(8),
                                            color: Colors.blueGrey),
                                        duration: const Duration(seconds: 1),
                                        curve: Curves.fastOutSlowIn,
                                      );
                                    })),
                                  ],
                                ),
                                Stack(
                                  children: [
                                    RotatedBox(
                                      quarterTurns: 2,
                                      child: Icon(Icons.airplanemode_active),
                                    )
                                  ],
                                )
                              ],
                            ),
                          )),
                    )
                  ],
                ),
              )
            ],
          )),
    );

    // return SafeArea(
    //     child: PageView.builder(
    //         scrollDirection: Axis.vertical,
    //         itemCount: images.length,
    //         itemBuilder: (_, index) {
    //           return Container(
    //             height: MediaQuery.of(context).size.height,
    //             width: MediaQuery.of(context).size.width,
    //             decoration: BoxDecoration(
    //                 image: DecorationImage(
    //                     fit: BoxFit.cover, image: AssetImage(images[index]))),
    //           );
    //         }));
  }
}

// class SideScrollBar extends StatelessWidget {
//   const SideScrollBar({
//     super.key,
//   });

//   @override
//   Widget build(BuildContext context) {
//     return Column(
//         children: List.generate(3, (index) {
//       return AnimatedContainer(
//         width: 8,
//         height: scrollBarHeight,
//         decoration: BoxDecoration(
//             borderRadius: BorderRadius.circular(8), color: Colors.blueGrey),
//         duration: const Duration(seconds: 1),
//         curve: Curves.fastOutSlowIn,
//       );
//     }));
//   }
// }

Future<http.Response> fetchBudget() {
  return http.get(Uri.parse('https://jsonplaceholder.typicode.com/albums/1'));
}
