function solution(command) {

    switch (command){
        case 'upvote':{
            this.upvotes++;
            break;
        }
        case 'downvote':{
            this.downvotes++;
            break;
        }
        case 'score':{
            let upvotes = this.upvotes;
            let downvotes = this.downvotes;
            let rank = 'new';
            let totalVotes = upvotes + downvotes;

            if(upvotes + downvotes >= 10){
                if(upvotes > 0.66 * totalVotes){
                    rank = 'hot';
                }else if(downvotes > upvotes){
                    rank = 'unpopular';
                }else if((upvotes-downvotes > 0) && upvotes > 100 || downvotes > 100){
                    rank = 'controversial';
                }
            }

            if(totalVotes > 50){
                let addition = Math.ceil(0.25 * Math.max(upvotes, downvotes));
                upvotes += addition;
                downvotes +=addition;
            }

            let votesDifference = upvotes-downvotes;

            return [upvotes, downvotes, votesDifference, rank];
        }
    }
}