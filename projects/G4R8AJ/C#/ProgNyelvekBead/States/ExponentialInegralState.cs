﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProgNyelvekBead.States
{
    class ExponentialInegralState : AbstractState
    {
        public ExponentialInegralState(String word, String curVal) : base(word, curVal) { }

        protected override void calculateNextState(char curChar)
        {
            if (Char.IsDigit(curChar))
            {
                this.remWord = this.remWord.Remove(0, 1);
                this.curVal = this.curVal + curChar.ToString();
                this.followingState = this;
            }
            else if (curChar == '.')
            {

                this.remWord = this.remWord.Remove(0, 1);
                this.curVal = this.curVal + ".";
                this.followingState = new ExponentialFractureState(remWord, curVal);
            }
            else
            {
                this.followingState = null;
            }
        }
    }
}
