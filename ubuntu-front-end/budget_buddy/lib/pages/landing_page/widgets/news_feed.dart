import 'package:flutter/material.dart';

class NewsFeed extends StatefulWidget {
  const NewsFeed({super.key});

  //final int

  @override
  State<NewsFeed> createState() => _NewsFeedState();
}

class _NewsFeedState extends State<NewsFeed> {
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      physics: const ClampingScrollPhysics(),
      itemCount: 10,
      itemBuilder: (BuildContext context, int index) {
        return Padding(
          padding: const EdgeInsets.all(8.0),
          child: Container(
            height: 90,
            decoration: BoxDecoration(
              color: Colors.transparent,
              borderRadius: BorderRadius.circular(8.0),
              // boxShadow: [
              //   BoxShadow(
              //       blurRadius: 3,
              //       color: Colors.black.withOpacity(0.5),
              //       offset: const Offset(0, 3)),]
            ),
            child: Row(
              children: [
                Container(
                  //height: 80,
                  width: 80,
                  margin: const EdgeInsets.fromLTRB(0, 0, 10, 0),
                  decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(20.0),
                      image: const DecorationImage(
                          image: AssetImage("/images/background_image_1.jpg"),
                          fit: BoxFit.cover)),
                ),
                const Expanded(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Padding(
                        padding: EdgeInsets.fromLTRB(0, 10.0, 0, 5.0),
                        child: Text(
                          "Micky is doing really well. Let's go babyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                          ),
                          maxLines: 2,
                          overflow: TextOverflow.ellipsis,
                        ),
                      ),
                      Padding(
                        padding: EdgeInsets.fromLTRB(0, 8.0, 0, 0),
                        child: Row(
                          children: [
                            Icon(
                              Icons.schedule,
                              size: 18.0,
                            ),
                            Text(
                              "viewed: 80 times",
                              style:
                                  TextStyle(fontSize: 8.0, color: Colors.grey),
                            )
                          ],
                        ),
                      )
                    ],
                  ),
                )
              ],
            ),
          ),
        );
      },
    );
  }
}
