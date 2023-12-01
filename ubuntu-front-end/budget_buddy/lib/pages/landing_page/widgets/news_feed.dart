import 'package:flutter/material.dart';

class NewsFeed extends StatefulWidget {
  const NewsFeed({super.key});

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
                color: Colors.indigo[100],
                borderRadius: BorderRadius.circular(8.0),
                boxShadow: [
                  BoxShadow(
                      blurRadius: 3,
                      color: Colors.black.withOpacity(0.5),
                      offset: const Offset(0, 3)),
                ]),
            child: Stack(
              children: [
                Row(
                  children: [
                    Flexible(
                      child: Container(
                        child: const Padding(
                          padding: EdgeInsets.all(8.0),
                          child: Text(
                            "Micky is doing really well now. Lets go babyyyyyyyyy",
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                      ),
                    ),
                  ],
                )
              ],
            ),
          ),
        );
      },
    );
  }
}
